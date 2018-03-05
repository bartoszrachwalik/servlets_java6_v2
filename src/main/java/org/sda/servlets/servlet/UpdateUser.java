package org.sda.servlets.servlet;

import org.sda.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateuser")
public class UpdateUser extends CommonServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUserRepository().findById(Long.valueOf(req.getParameter("id")));

        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));

        getUserRepository().update(user);

        resp.sendRedirect("/users");
    }
}
