package com.maithmuzic.core.test;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LambdaContext implements Context {
    private FakeLambdaLogger fakeLambdaLogger;

    public LambdaContext() {
        fakeLambdaLogger = new FakeLambdaLogger();
    }

    public ClientContext getClientContext() {
        return null;
    }

    public int getMemoryLimitInMB() {
        return 0;
    }

    public int getRemainingTimeInMillis() {
        return 0;
    }

    public String getFunctionName() {
        return null;
    }

    public CognitoIdentity getIdentity() {
        return null;
    }

    public String getFunctionVersion() {
        return null;
    }

    public String getAwsRequestId() {
        return null;
    }

    public String getInvokedFunctionArn() {
        return null;
    }

    public String getLogGroupName() {
        return null;
    }

    public String getLogStreamName() {
        return null;
    }

    public LambdaLogger getLogger() {
        return fakeLambdaLogger;
    }
}

class FakeLambdaLogger implements LambdaLogger {
    private PrettyPriter prettyPriter;

    public FakeLambdaLogger() {
        this.prettyPriter = new PrettyPriter();
    }

    public void log(String string) {
        System.out.println(string);
    }

    public void log(Object object) {
        System.out.println(object);
    }

    public void log(Object object, boolean pretty) {
        prettyPriter.print(object);
    }

    @Override
    public void log(byte[] message) {
        // TODO:
    }

    private class PrettyPriter {
        private Gson prettier;

        public PrettyPriter() {
            prettier = new GsonBuilder().setPrettyPrinting().create();
        }
        public void print(String string) {
            System.out.println(string);
        }

        public void print(Object object) {
            System.out.println(prettier.toJson(object));
        }
    }
}

