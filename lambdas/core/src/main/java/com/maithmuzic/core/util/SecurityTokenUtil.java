package com.maithmuzic.core.util;

import java.security.SecureRandom;
import java.util.UUID;

public class SecurityTokenUtil {
    // FIXME:
    public static String generateSecurityToken() {
        return UUID.randomUUID().toString();
    }
}
