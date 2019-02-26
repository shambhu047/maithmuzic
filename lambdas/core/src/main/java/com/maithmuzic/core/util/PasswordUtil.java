package com.maithmuzic.core.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.nio.charset.Charset;

// REFERENCE: https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet
public class PasswordUtil {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public static String hash( String password, Charset charset) {
        String hash;
        char[] passwordSplitted = null;
        Argon2 hasher = null;

        try {
            passwordSplitted = password.toCharArray();
            hasher = createArgon2Instance();

            int iterationCount = 10;
            int memoryAmountToUse = 128;
            int threadsToUse = 4;

            hash = hasher.hash(iterationCount, memoryAmountToUse, threadsToUse, passwordSplitted, charset);
        } finally {
            if (hasher != null) {
                hasher.wipeArray(passwordSplitted);
            }
        }

        return hash;
    }

    public static String hash( String password) {
        return hash(password, DEFAULT_CHARSET);
    }

    public static boolean verify( String hash, String password, Charset charset) {
        Argon2 hasher = null;
        char[] passwordSplitted = null;
        boolean isSame;

        try {
            hasher = createArgon2Instance();
            passwordSplitted = password.toCharArray();
            isSame = hasher.verify(hash, password, charset);
        } finally {
            if (hasher != null) {
                hasher.wipeArray(passwordSplitted);
            }
        }

        return isSame;
    }

    public static boolean verify(String hash, String password) {
        return verify(hash, password, DEFAULT_CHARSET);
    }

    private static Argon2 createArgon2Instance() {
        return Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
    }
}
