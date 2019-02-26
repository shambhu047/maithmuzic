package com.maithmuzic.core.api.exception;

import com.maithmuzic.common.http.HttpResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class ExceptionConstants {
    public static Map<String, String> MESSAGES = new HashMap<>();

    static {
        MESSAGES.put(ExceptionType.NO_SECURITY_TOKEN.name(), "Security Token is mandatory for this action !");
        MESSAGES.put(ExceptionType.EMPTY_SECURITY_TOKEN.name(), "Security Token cannot be empty or null !");
        MESSAGES.put(ExceptionType.INVALID_SECURITY_TOKEN.name(), "Invalid security token");
        MESSAGES.put(ExceptionType.INTERNAL_SERVER_ERROR.name(), "Internal Sever Error");
        MESSAGES.put(ExceptionType.RESOURCE_NOT_FOUND.name(), "Resource Not Found");
        MESSAGES.put(ExceptionType.METHOD_NOT_ALLOWED.name(), "Method not allowed");
        MESSAGES.put(ExceptionType.BAD_REQUEST.name(), "Bad Request");
        MESSAGES.put(ExceptionType.UNSUPPORTED_MEDIA_TYPE.name(), "Unsupported Media Type");
    }

    public static Map<String, HttpResponseStatus> HttpResponseStatusMap = new HashMap<>();

    static {
        HttpResponseStatusMap.put(ExceptionType.NO_SECURITY_TOKEN.name(), HttpResponseStatus.Unauthorized);
        HttpResponseStatusMap.put(ExceptionType.EMPTY_SECURITY_TOKEN.name(), HttpResponseStatus.Unauthorized);
        HttpResponseStatusMap.put(ExceptionType.INVALID_SECURITY_TOKEN.name(), HttpResponseStatus.Unauthorized);
        HttpResponseStatusMap.put(ExceptionType.INTERNAL_SERVER_ERROR.name(), HttpResponseStatus.InternalServerError);
        HttpResponseStatusMap.put(ExceptionType.RESOURCE_NOT_FOUND.name(), HttpResponseStatus.NotFound);
        HttpResponseStatusMap.put(ExceptionType.METHOD_NOT_ALLOWED.name(), HttpResponseStatus.MethodNotAllowed);
        HttpResponseStatusMap.put(ExceptionType.BAD_REQUEST.name(), HttpResponseStatus.BadRequest);
        HttpResponseStatusMap.put(ExceptionType.UNSUPPORTED_MEDIA_TYPE.name(), HttpResponseStatus.UnsupportedMediaType);
    }
}
