package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.List;
import java.util.stream.Collectors;

public enum UserRole {
    Admin,
    EndUser;

    public static class UserRoleConverter implements DynamoDBTypeConverter<String, UserRole> {

        @Override
        public String convert(UserRole userRole) {
            return userRole.name();
        }

        @Override
        public UserRole unconvert(String role) {
            return UserRole.valueOf(role);
        }
    }

    public static class UserRolesListConverter implements DynamoDBTypeConverter<List<String>, List<UserRole>> {

        @Override
        public List<String> convert(List<UserRole> userRoles) {
            return userRoles.stream().map(r -> r.name()).collect(Collectors.toList());
        }

        @Override
        public List<UserRole> unconvert(List<String> roles) {
            return roles.stream().map(r -> UserRole.valueOf(r)).collect(Collectors.toList());
        }
    }
}
