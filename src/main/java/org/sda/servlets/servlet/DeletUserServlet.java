package org.sda.servlets.servlet;

import org.sda.domain.User;
import org.sda.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteuser")
public class DeletUserServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        this.getServletContext());
        userRepository = context.getBean(UserRepository.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        userRepository.deleteById(id);

        resp.sendRedirect("/users");
    }
}
