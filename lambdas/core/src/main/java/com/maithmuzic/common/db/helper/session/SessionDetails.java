package com.maithmuzic.common.db.helper.session;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class SessionDetails {
    private Client client;

    private String ipAddress;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static class SessionDetailsConverter implements DynamoDBTypeConverter<String, SessionDetails> {

        @Override
        public String convert(SessionDetails sessionDetails) {
            Gson gson = new Gson();
            return gson.toJson(sessionDetails);
        }

        @Override
        public SessionDetails unconvert(String sessionDetails) {
            Gson gson = new Gson();

            Type type = new TypeToken<SessionDetails>(){}.getType();
            return gson.fromJson(sessionDetails, type);
        }
    }

    @Override
    public String toString() {
        return "SessionDetails{" +
                "client=" + client +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
