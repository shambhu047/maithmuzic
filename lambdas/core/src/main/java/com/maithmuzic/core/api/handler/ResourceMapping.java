package com.maithmuzic.core.api.handler;

import com.maithmuzic.common.http.HTTPMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ResourceMapping {
    String path();
    HTTPMethod method();
}
