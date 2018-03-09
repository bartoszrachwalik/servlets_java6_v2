package org.sda.servlets.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sda.domain.Course;
import org.sda.domain.Review;
import org.sda.repository.CourseRepository;
import org.sda.repository.ReviewRepository;
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

@WebServlet (name = "/addreview" )
public class AddReviewServlet extends HttpServlet {

    private ReviewRepository reviewRepository;
    private CourseRepository courseRepository;

    static final Logger logger = LogManager.getLogger(TestServlet.class.getName());

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        this.getServletContext());
        reviewRepository = context.getBean(ReviewRepository.class);
        courseRepository = context.getBean(CourseRepository.class);
        logger.info("TestServlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String rating = req.getParameter("rating");
        String description = req.getParameter("description");
        String idCourse= req.getParameter("id");

        Review review= new Review(rating, description);
        Course course= courseRepository.findById(Long.valueOf(req.getParameter("id")));
        review.setCourse(course);


        Set<ConstraintViolation<Review>> violations = ValidationUtil.validateInternal(review);
        for (ConstraintViolation<Review> violation : violations) {
            logger.info(violation.getPropertyPath() + " : " + violation.getMessage()
                    + " " + violation.getMessageTemplate());
        }

        if (violations.isEmpty()) {
            reviewRepository.save(review);
            req.setAttribute("review", review);
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/pages/addedreview.jsp");
            requestDispatcher.forward(req, resp);
        } else {

            req.setAttribute("errors",violations);
            req.setAttribute("review", review);
            RequestDispatcher requestDispatcher =
                    req.getRequestDispatcher("/pages/addreview.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
