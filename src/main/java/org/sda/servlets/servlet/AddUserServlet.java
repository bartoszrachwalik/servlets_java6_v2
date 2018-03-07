package org.sda.servlets.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sda.domain.Password;
import org.sda.domain.User;
import org.sda.repository.UserRepository;
import org.sda.util.PasswordUtil;
import org.sda.util.UserValidation;
import org.sda.util.ValidationUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.Set;

@WebServlet(value = "/adduser")
public class AddUserServlet extends HttpServlet {

    private UserRepository userRepository;

    static final Logger logger = LogManager.getLogger(TestServlet.class.getName());

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        this.getServletContext());
        userRepository = context.getBean(UserRepository.class);
        logger.info("TestServlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        Password passwordClass= new Password();
        passwordClass.setUser(user);
        passwordClass.setValue(PasswordUtil.hashPassword(password));

        Set<ConstraintViolation<User>> violations = ValidationUtil.validateInternal(user);
        for (ConstraintViolation<User> violation : violations) {
            logger.info(violation.getPropertyPath() + " : " + violation.getMessage()
            + " " + violation.getMessageTemplate());
        }

        if (violations.isEmpty()) {
            userRepository.save(user, passwordClass);

            request.setAttribute("user", user);
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/pages/afterregistration.jsp");
            requestDispatcher.forward(request, response);
        } else {

            request.setAttribute("errors",violations);
            request.setAttribute("user",user);
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/pages/registration.jsp");
            requestDispatcher.forward(request, response);
        }
    }


}
