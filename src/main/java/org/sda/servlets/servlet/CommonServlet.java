package org.sda.servlets.servlet;

import org.sda.repository.CourseRepository;
import org.sda.repository.ReviewRepository;
import org.sda.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet
public class CommonServlet extends HttpServlet {

    private UserRepository userRepository;
    private CourseRepository courseRepository;
    private ReviewRepository reviewRepository;

    UserRepository getUserRepository() {
        return userRepository;
    }

    CourseRepository getCourseRepository() {
        return courseRepository;
    }

    ReviewRepository getReviewRepository() {
        return reviewRepository;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        this.getServletContext());
        userRepository = context.getBean(UserRepository.class);
        courseRepository = context.getBean(CourseRepository.class);
        reviewRepository = context.getBean(ReviewRepository.class);
    }
}
