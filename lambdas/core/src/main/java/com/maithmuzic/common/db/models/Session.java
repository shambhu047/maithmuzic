package com.maithmuzic.common.db.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.maithmuzic.common.db.helper.session.Platform;
import com.maithmuzic.common.db.helper.session.SessionDetails;

import java.util.Date;

@DynamoDBDocument
public abstract class Session {
    protected String sessionId;

    protected String securityToken;

    @DynamoDBAttribute(attributeName = "StartTime")
    private Date startTime;

    @DynamoDBAttribute(attributeName = "EndTime")
    private Date endTime;

    @DynamoDBAttribute(attributeName = "LastActivityTime")
    private Date lastActivityTime;

    @DynamoDBAttribute(attributeName = "IsValid")
    private boolean isValid;

    protected String username;

    @DynamoDBAttribute(attributeName = "Platform")
    @DynamoDBTypeConverted(converter = Platform.PlatformConverter.class)
    private Platform platform;

    @DynamoDBAttribute(attributeName = "SessionDetails")
    @DynamoDBTypeConverted(converter = SessionDetails.SessionDetailsConverter.class)
    private SessionDetails sessionDetails;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Date lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SessionDetails getSessionDetails() {
        return sessionDetails;
    }

    public void setSessionDetails(SessionDetails sessionDetails) {
        this.sessionDetails = sessionDetails;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId='" + sessionId + '\'' +
                ", securityToken=" + securityToken +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", lastActivityTime=" + lastActivityTime +
                ", isValid=" + isValid +
                ", username='" + username + '\'' +
                ", platform=" + platform +
                ", sessionDetails=" + sessionDetails +
                '}';
    }
}
