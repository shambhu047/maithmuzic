package com.maithmuzic.common.db.models;

import java.util.List;

public class UserGroup {
    private String id;

    private List<UserRole> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
