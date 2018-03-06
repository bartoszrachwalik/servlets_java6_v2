package org.sda.util;

import org.sda.domain.User;

/**
 * Nasza własna walidacja dla usera
 */
public class UserValidation {

    private UserValidation() {
    }

    public static boolean validate(User user) {
        return user.getFirstName() != null && !user.getFirstName().isEmpty()
                && user.getLastName() != null && !user.getLastName().isEmpty()
                && user.getEmail() != null && !user.getEmail().isEmpty();
    }


}
