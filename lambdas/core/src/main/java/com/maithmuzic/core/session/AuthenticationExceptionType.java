package com.maithmuzic.core.session;

public enum AuthenticationExceptionType {
    INVALID_USERNAME,
    INVALID_PASSWORD,
    INVALID_USERNAME_OR_INVALID_PASSWORD,
    UNKNOWN_CLIENT,
    UNKNOWN_ERROR,
    INVALID_SECURITY_TOKEN,
}
