package com.maithmuzic.core.api.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maithmuzic.common.aws.apiGateway.ApiGatewayRequest;
import com.maithmuzic.common.aws.apiGateway.LambdaProxyIntegrationResponse;
import com.maithmuzic.common.http.HttpResponseStatus;
import com.maithmuzic.core.api.exception.ExceptionConstants;
import com.maithmuzic.core.api.exception.ExceptionType;
import com.maithmuzic.core.api.exception.LambdaProxyHandlerException;
import com.maithmuzic.core.api.resources.ResourceRegistry;
import com.maithmuzic.core.api.restfull.ResourceAction;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Router implements RequestStreamHandler {

    private LambdaLogger logger;

    private Gson gson;

    public Router() {
        logger = null;
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void handleRequest(InputStream requestStream, OutputStream responseStream, Context context) throws IOException {

        preProcessActivity(context);

        ApiGatewayRequest request = null;

        LambdaProxyIntegrationResponse response = new LambdaProxyIntegrationResponse();
        response.setBase64Encoded(false);
        response.setStatusCode(HttpResponseStatus.Ok.getCode());

        try {
            try {
                String rawRequest = IOUtils.toString(requestStream, StandardCharsets.UTF_8);
                request = new Gson().fromJson(rawRequest, ApiGatewayRequest.class);
                RequestUtil.normalizeRequest(request);
            } catch (Exception e) {
                throw new LambdaProxyHandlerException(ExceptionType.INTERNAL_SERVER_ERROR);
            }

            String path = request.getPath();
            String httpMethod = request.getHttpMethod();

            logger.log("Received path -> " + path);
            logger.log("Received Method -> " + httpMethod);
            logger.log("Received Resource -> " + request.getResource());

            ResourceAction action = ResourceAction.valueOf(httpMethod);

            if (!ResourceRegistry.isResourceAvalable(path)) {
                throw new LambdaProxyHandlerException(ExceptionType.RESOURCE_NOT_FOUND);
            }

            if (!ResourceRegistry.isActionAllowed(path, action)) {
                throw new LambdaProxyHandlerException(ExceptionType.METHOD_NOT_ALLOWED);
            }

            if (ResourceRegistry.isResourceSecure(path)) {
                // TODO: Authentication
            }

            IActionHandler handler = ResourceRegistry.getActionHandler(path, action).newInstance();

            LambdaProxyIntegrationResponse r =handler.handle(request, context) ;

            // TODO: validate response (r)

            response = r;
        } catch (LambdaProxyHandlerException e) {
            e.printStackTrace();
            response.setBody(null); // FIXME:
            response.setStatusCode(e.httpResponseStatus.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            response.setBody(null); // TODO:
            response.setStatusCode(ExceptionConstants.HttpResponseStatusMap.get(ExceptionType.INTERNAL_SERVER_ERROR.name()).getCode());
        }

        IOUtils.write(gson.toJson(response, LambdaProxyIntegrationResponse.class), responseStream,
                StandardCharsets.UTF_8);
    }

    private void preProcessActivity(Context context) {
        logger = context.getLogger();
    }
}
