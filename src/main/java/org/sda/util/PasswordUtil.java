package org.sda.util;

import org.springframework.security.crypto.bcrypt.BCrypt;


/**
 *  Util który pozwala szyfrowac i porównywać hasła
 */
public class PasswordUtil {

    private static int workload = 12;

    /**
     *
     * @param password_plaintext hasło do zahaszowania
     * @return hash hasła
     */
    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }

    /**
     * Porównuje podane hasło i hash
     * @param password_plaintext Hasło nie zakodowane
     * @param stored_hash Hash hasła
     * @return zwaraca TRUE jeśli hash odpowiada nie zakodowanemu hasłu
     */
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if(null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return(password_verified);
    }
}
