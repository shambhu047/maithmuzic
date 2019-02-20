package com.maithmuzic.core.session;

import com.maithmuzic.common.db.helper.session.Client;

public class LoginRequest {
    private String username;

    private String password;

    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", client=" + client +
                '}';
    }
}
