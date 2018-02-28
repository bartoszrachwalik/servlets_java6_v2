package org.sda.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
        String username = "javawro6@gmail.com";
        String password = "java6wro";
        return new PasswordAuthentication(username, password);
    }
}
