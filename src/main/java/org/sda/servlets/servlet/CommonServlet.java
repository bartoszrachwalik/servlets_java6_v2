package org.sda.servlets.servlet;

import org.sda.repository.CourseRepository;
import org.sda.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class CommonServlet extends HttpServlet {

    private UserRepository userRepository;
    private CourseRepository courseRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        this.getServletContext());
        userRepository = context.getBean(UserRepository.class);
        courseRepository = context.getBean(CourseRepository.class);
    }
}
