package org.sda.servlets.servlet;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sda.domain.Password;
import org.sda.domain.User;
import org.sda.util.PasswordUtil;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userlogin")
public class LoginServlet extends CommonServlet {

    private static final Logger logger = LogManager.getLogger(LoginServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            User user = getUserRepository().findByEmail(email);
            if (user != null) {
                Password passwordEntity = getUserRepository().findBy(user);

                if (passwordEntity != null && PasswordUtil.checkPassword(password, passwordEntity.getValue())) {
                    HttpSession session = req.getSession();
                    session.setAttribute("loggedUser", user);

                    resp.sendRedirect("/users");
                    return;
                }
            }
        } catch (NoResultException e) {
            logger.error("error during login", e);
        }
        resp.sendRedirect("/pages/login.jsp");
    }
}
