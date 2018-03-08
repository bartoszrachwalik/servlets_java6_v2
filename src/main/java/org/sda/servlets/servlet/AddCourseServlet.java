package org.sda.servlets.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sda.domain.Course;
import org.sda.domain.User;
import org.sda.util.ValidationUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.Set;

@WebServlet(value = "/addcourse")
public class AddCourseServlet extends CommonServlet {

    private CourseRepository courseRepository;
    private static final Logger logger = LogManager.getLogger(TestServlet.class.getName());


    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Course course = new Course();
        course.setName(name);

        Set<ConstraintViolation<Course>> violations = ValidationUtil.validateInternal(course);

        for (ConstraintViolation<Course> violation : violations) {
            logger.info(violation.getPropertyPath() + " : " + violation.getMessage()
                    + " " + violation.getMessageTemplate());
        }

        if (violations.isEmpty()) {
            CourseRepository.save(course);

            request.setAttribute("course", course);
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/pages/afteraddcourse.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("errors", violations);
            request.setAttribute("course", course);
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/pages/addcourse.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
