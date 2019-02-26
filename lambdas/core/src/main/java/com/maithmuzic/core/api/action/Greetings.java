package com.maithmuzic.core.api.action;

import com.amazonaws.services.lambda.runtime.Context;
import com.maithmuzic.common.aws.apiGateway.ApiGatewayRequest;
import com.maithmuzic.common.aws.apiGateway.LambdaProxyIntegrationResponse;
import com.maithmuzic.common.http.HttpResponseStatus;
import com.maithmuzic.core.api.handler.IActionHandler;

import java.util.HashMap;

public class Greetings implements IActionHandler {
    @Override
    public LambdaProxyIntegrationResponse handle(ApiGatewayRequest request, Context context) {
        LambdaProxyIntegrationResponse response = new LambdaProxyIntegrationResponse();
        response.setStatusCode(HttpResponseStatus.Ok.getCode());
        response.setBody("Hi!");
        response.setBase64Encoded(false);
        response.setHeaders(new HashMap<>());

        return response;
    }
}
