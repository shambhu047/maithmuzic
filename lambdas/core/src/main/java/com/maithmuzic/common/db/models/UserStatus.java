package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public enum UserStatus {
    VerificationPending,
    Active,
    Blocked,
    Inactive;

    public static class UserStatusConverter implements DynamoDBTypeConverter<String, UserStatus> {

        @Override
        public String convert(UserStatus userStatus) {
            return userStatus.name();
        }

        @Override
        public UserStatus unconvert(String status) {
            return UserStatus.valueOf(status);
        }
    }
}
