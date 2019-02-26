package com.maithmuzic.core.session;

public class AuthenticationException extends Exception {
    AuthenticationException(AuthenticationExceptionType exceptionType) {
        super(exceptionType.name());
    }
}
