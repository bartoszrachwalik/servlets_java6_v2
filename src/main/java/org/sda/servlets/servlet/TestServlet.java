package org.sda.servlets.servlet;


import org.sda.repository.UserRepository;
import org.sda.util.Constans;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(value = Constans.TEST_SERVLET)
public class TestServlet extends HttpServlet {

    private long counter = 0;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param = request.getParameter("param1");

        PrintWriter out = response.getWriter();
        out.println("Hello " + param);

        List<String> strings = new ArrayList<>();
        for(String jakisString : strings){

        }
    }
}
