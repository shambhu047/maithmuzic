package com.maithmuzic.common.db.helper.session;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public enum Platform {
    Web,
    Mobile;

    public static class PlatformConverter implements DynamoDBTypeConverter<String, Platform> {

        @Override
        public String convert(Platform platform) {
            return platform.name();
        }

        @Override
        public Platform unconvert(String platform) {
            return Platform.valueOf(platform);
        }
    }
}
