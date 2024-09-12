package dubovikLera.servlet;

import dubovikLera.dao.ReviewsDao;
import dubovikLera.entity.OrderedProducts;
import dubovikLera.entity.Reviews;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet("/reviews")
public class ReviewServlet extends HttpServlet {
    private final ReviewsDao reviewsDao = ReviewsDao.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String date = request.getParameter("date");
        int orderedProductId = Integer.parseInt(request.getParameter("orders_product_id"));

        Reviews review = new Reviews();
        review.setComment(comment);
        review.setRating(rating);
        review.setDate(Timestamp.valueOf(date));

        OrderedProducts orderedProduct = new OrderedProducts();
        orderedProduct.setId(orderedProductId);
        review.setOrdered_product_id(orderedProduct);

        reviewsDao.save(review);

        response.sendRedirect("success.html");
    }
}