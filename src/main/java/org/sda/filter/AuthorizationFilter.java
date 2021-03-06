package org.sda.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private List<String> whiteList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whiteList.add("/pages/registration.jsp");
        whiteList.add("/pages/afterregistration.jsp");
        whiteList.add("/pages/login.jsp");
        whiteList.add("/adduser");
        whiteList.add("/adduser2");
        whiteList.add("/userlogin");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        if(whiteList.contains(req.getRequestURI()) || session.getAttribute("loggedUser") != null) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect("/pages/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
