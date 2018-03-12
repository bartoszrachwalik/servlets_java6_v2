package org.sda.servlets.servlet;

import org.sda.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class FindUsersServlet extends CommonServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = getUserRepository().findAll();

        req.setAttribute("users", userList);

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/pages/usersTable.jsp");
        requestDispatcher.forward(req, resp);
    }
}
