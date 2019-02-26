package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "SessionsDump")
public class StaleSession extends Session {
    @Override
    @DynamoDBAttribute(attributeName = "SecurityToken")
    public String getSecurityToken() {
        return securityToken;
    }

    @Override
    @DynamoDBRangeKey(attributeName = "SessionId")
    public String getSessionId() {
        return sessionId;
    }

    @Override
    @DynamoDBHashKey(attributeName = "Username")
    public String getUsername() {
        return username;
    }
}
