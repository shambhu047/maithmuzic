package com.maithmuzic.core.session;

import com.maithmuzic.common.db.models.Session;

public class AuthProvider {
    private static AuthProvider provider;

    private final Authenticator authenticator;

    public static AuthProvider getInstance() {
        if (provider == null) {
            provider = new AuthProvider();
        }

        return provider;
    }

    private AuthProvider() {
        authenticator = Authenticator.getInstance();
    }

    public LoginResponse login(LoginRequest request) {
        LoginResponse loginResponse = new LoginResponse();

        try {
            Session session = authenticator.createSession(request);
            loginResponse.setSuccess(true);
            loginResponse.setSecurityToken(session.getSecurityToken());
        } catch (AuthenticationException ae) {
            loginResponse.setSuccess(false);
        } catch (Exception e) {
            loginResponse.setSuccess(false);
        }

        return loginResponse;
    }
}
