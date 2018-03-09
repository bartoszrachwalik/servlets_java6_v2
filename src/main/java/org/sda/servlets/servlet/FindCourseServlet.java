package org.sda.servlets.servlet;

import org.sda.domain.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/courses")
public class FindCourseServlet extends CommonServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courseList = getCourseRepository().findAll();

        Map<Course, Double> mapAverage= new HashMap<>();

        for (Course course : courseList) {
            mapAverage.put(course, getCourseRepository().averageRating(course.getId()));
        }

        request.setAttribute("courses", courseList);
        request.setAttribute("average", mapAverage);

        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/pages/coursetable.jsp");
        requestDispatcher.forward(request, response);
    }
}
