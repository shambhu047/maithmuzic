package com.maithmuzic.core.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.maithmuzic.common.aws.apiGateway.ApiGatewayRequest;
import com.maithmuzic.core.api.handler.Router;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {

    private Gson gson;

    public Test() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static void main(String[] args) {
        Test test = new Test();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Router lambda = new Router();
        LambdaContext context = new LambdaContext();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream(gson.toJson(test.getGreetingsRequest()).getBytes());

        try {
            lambda.handleRequest(inputStream, outputStream, context);

            String response = new String(outputStream.toByteArray(), "UTF-8");
            System.out.println(response);
        } catch (IOException e) {
            // DO Something
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (Exception e) {
                // Do nothing
            }
        }
    }

    public ApiGatewayRequest getGreetingsRequest() {

        JsonObject requestBody = new JsonObject();

        ApiGatewayRequest apiEvent = new ApiGatewayRequest();
        apiEvent.setResource("/greetings");
        apiEvent.setPath("/greetings");
        apiEvent.setHttpMethod("GET");
        apiEvent.setBody(gson.toJson(requestBody));

        return apiEvent;
    }
}
