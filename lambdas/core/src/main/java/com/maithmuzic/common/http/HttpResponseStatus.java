package com.maithmuzic.common.http;

// TODO:
public enum HttpResponseStatus {
    Ok(200),

    Created(201),

    NoContent(204),

    BadRequest(400),

    Unauthorized(401),

    Forbidden(403),

    NotFound(404),

    MethodNotAllowed(405),

    Gone(410),

    InternalServerError(500),

    ServiceUnavailable(503),

    UnsupportedMediaType(415);

    private int code;

    private HttpResponseStatus(int statusCode) {
        this.code = statusCode;
    }

    public int getCode() {
        return code;
    }
}
