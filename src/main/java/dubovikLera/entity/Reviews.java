package dubovikLera.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Reviews {
    private Integer review_id;
    private String comment;
    private BigDecimal rating;
    private LocalDateTime date;
    private OrderedProducts ordered_product_id;

    public Reviews(Integer review_id, String comment, BigDecimal rating, LocalDateTime date, OrderedProducts ordered_product_id) {
        this.review_id = review_id;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.ordered_product_id = ordered_product_id;
    }

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public OrderedProducts getOrdered_product_id() {
        return ordered_product_id;
    }

    public void setOrdered_product_id(OrderedProducts ordered_product_id) {
        this.ordered_product_id = ordered_product_id;
    }

    @Override
    public String toString() {
        return "Reviews{" +
               "review_id=" + review_id +
               ", comment='" + comment + '\'' +
               ", rating=" + rating +
               ", date=" + date +
               ", ordered_product_id=" + ordered_product_id +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviews reviews = (Reviews) o;
        return Objects.equals(review_id, reviews.review_id) && Objects.equals(comment, reviews.comment) && Objects.equals(rating, reviews.rating) && Objects.equals(date, reviews.date) && Objects.equals(ordered_product_id, reviews.ordered_product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(review_id, comment, rating, date, ordered_product_id);
    }
}
