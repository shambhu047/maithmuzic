package com.maithmuzic.common.gateway;

import java.util.Map;

public class LambdaProxyIntegrationResponse {

    public final boolean isBase64Encoded;

    public final int statusCode;

    public final Map<String, String> headers;

    public final String body;

    public LambdaProxyIntegrationResponse(String body, Map headers, int statusCode, boolean isBase64Encoded) {
        this.body = body;
        this.headers = headers;
        this.statusCode = statusCode;
        this.isBase64Encoded = isBase64Encoded;
    }
}