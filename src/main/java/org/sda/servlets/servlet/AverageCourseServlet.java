package org.sda.servlets.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name="/averagecourse")
public class AverageCourseServlet extends CommonServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Double average = getCourseRepository().averageRating(id);
        req.setAttribute("average", average);
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/pages/coursetable.jsp");
        requestDispatcher.forward(req, resp);
    }
}
