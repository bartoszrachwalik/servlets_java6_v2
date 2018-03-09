package org.sda.servlets.servlet;

import org.sda.domain.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/courses")
public class FindCourseServlet extends CommonServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courseList = getCourseRepository().findAll();

        request.setAttribute("courses", courseList);

        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/pages/coursesTable.jsp");
        requestDispatcher.forward(request, response);
    }
}
