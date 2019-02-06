package com.maithmuzic.common.http;

// TODO:
public enum ResponseStatus {
    Ok(200),

    Created(201),

    NoContent(204),

    BadRequest(400),

    Unauthorized(401),

    Forbidden(403),

    NotFound(404),

    Gone(410),

    InternalServerError(500),

    ServiceUnavailable(503);

    private int code;

    private ResponseStatus(int statusCode) {
        this.code = statusCode;
    }

    public int getCode() {
        return code;
    }
}
