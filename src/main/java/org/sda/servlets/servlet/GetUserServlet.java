package org.sda.servlets.servlet;

import org.sda.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getuserdata")
public class GetUserServlet extends CommonServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUserRepository().findById(Long.valueOf(req.getParameter("id")));

        req.setAttribute("user", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/edituser.jsp");
        requestDispatcher.forward(req, resp);
    }
}
