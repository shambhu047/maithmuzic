package com.maithmuzic.common.aws.apiGateway;

import com.maithmuzic.common.http.HttpResponseStatus;

import java.util.Map;

public class LambdaProxyIntegrationResponse {

    public boolean isBase64Encoded;

    public int statusCode;

    public Map<String, String> headers;

    public String body;

    public LambdaProxyIntegrationResponse(String body, Map headers, int statusCode, boolean isBase64Encoded) {
        this.body = body;
        this.headers = headers;
        this.statusCode = statusCode;
        this.isBase64Encoded = isBase64Encoded;
    }

    public LambdaProxyIntegrationResponse() {
        // TODO:
        this(null, null, HttpResponseStatus.NoContent.getCode(), false);
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public void setBase64Encoded(boolean base64Encoded) {
        isBase64Encoded = base64Encoded;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "LambdaProxyIntegrationResponse{" +
                "isBase64Encoded=" + isBase64Encoded +
                ", statusCode=" + statusCode +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
}