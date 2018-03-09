package org.sda.servlets.servlet;

import org.sda.domain.Review;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="/showreview")
public class ShowReviewServlet extends CommonServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Review> reviews = getReviewRepository().findAll();
        req.setAttribute("reviews", reviews);
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/pages/reviewTable.jsp");
        requestDispatcher.forward(req, resp);
    }
}
