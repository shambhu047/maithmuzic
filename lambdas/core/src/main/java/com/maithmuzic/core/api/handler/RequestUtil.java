package com.maithmuzic.core.api.handler;

import com.maithmuzic.common.aws.apiGateway.ApiGatewayRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class RequestUtil {
    private RequestUtil() {}

    public static void normalizeRequest(ApiGatewayRequest request) {
        // headers
        Map<String, String> newHeaders;

        if (request.getHeaders()  != null) {
            Map<String, String> originalHeaders = request.getHeaders();

            newHeaders = originalHeaders.entrySet().stream().collect(
                    Collectors.toMap(h -> h.getKey().toLowerCase(), h -> h.getValue())
            );

        } else {
            newHeaders = new HashMap<>();
        }

        request.setHeaders(newHeaders);

        if (request.getQueryStringParameters() == null) {
            request.setQueryStringParameters(new HashMap<>());
        }
    }
}
