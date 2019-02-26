package com.maithmuzic.core.api.exception;

import com.maithmuzic.common.http.HttpResponseStatus;

import java.util.ArrayList;

public class LambdaProxyHandlerException extends Exception {
    public final HttpResponseStatus httpResponseStatus;

    public LambdaProxyHandlerException(ExceptionType exceptionType) {
        super(ExceptionConstants.MESSAGES.get(exceptionType.name()));
        httpResponseStatus = ExceptionConstants.HttpResponseStatusMap.get(exceptionType.name());
    }

    public LambdaProxyHandlerException(ExceptionType exceptionType, ArrayList<String> errors) {
        super(String.join("\n", errors));
        httpResponseStatus = ExceptionConstants.HttpResponseStatusMap.get(exceptionType.name());
    }
}
