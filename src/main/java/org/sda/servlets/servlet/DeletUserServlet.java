package org.sda.servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteuser")
public class DeletUserServlet extends CommonServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        getUserRepository().deleteById(id);

        resp.sendRedirect("/users");
    }
}
