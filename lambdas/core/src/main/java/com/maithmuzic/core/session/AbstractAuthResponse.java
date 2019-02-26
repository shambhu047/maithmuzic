package com.maithmuzic.core.session;

import java.util.ArrayList;

public abstract class AbstractAuthResponse {
    public final ArrayList<String> errors;

    public final ArrayList<String> warning;

    private boolean success;

    AbstractAuthResponse() {
        errors = new ArrayList<>();
        warning = new ArrayList<>();
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
