package org.sda.servlets.servlet;

import org.sda.domain.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getcoursedata")
public class GetCourseServlet extends CommonServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = getCourseRepository().findById(Long.valueOf(req.getParameter("id")));

        req.setAttribute("course", course);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/addrewiev.jsp");
        requestDispatcher.forward(req, resp);
    }
}
