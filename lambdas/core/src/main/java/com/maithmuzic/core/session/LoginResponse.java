package com.maithmuzic.core.session;

public class LoginResponse extends AbstractAuthResponse {
    private String securityToken;

    LoginResponse() {
        super();
        securityToken = null;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "securityToken=" + securityToken +
                ", errors=" + errors +
                ", warning=" + warning +
                ", success=" + isSuccess() +
                '}';
    }
}
