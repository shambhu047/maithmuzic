package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Users")
public class User {
    @DynamoDBHashKey(attributeName = "Username")
    private String username;

    @DynamoDBAttribute(attributeName = "Password")
    private String password;

    @DynamoDBAttribute(attributeName = "Email")
    private String email;

    @DynamoDBAttribute(attributeName = "PhoneNumber")
    private String phoneNumber;

    @DynamoDBAttribute(attributeName = "Country")
    private String country;

    @DynamoDBAttribute(attributeName = "GroupId")
    private String groupId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", country='" + country + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
