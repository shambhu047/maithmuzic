package com.maithmuzic.core.api.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.maithmuzic.common.aws.apiGateway.ApiGatewayRequest;
import com.maithmuzic.common.aws.apiGateway.LambdaProxyIntegrationResponse;

public interface IActionHandler {
    public abstract LambdaProxyIntegrationResponse handle(ApiGatewayRequest request, Context context);
}
