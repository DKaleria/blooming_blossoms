package dubovikLera.dto;

import dubovikLera.entity.OrderedProducts;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Value
@Builder
public class ReviewsDto {
    Integer review_id;
    String comment;
    Integer rating;
    Timestamp date;
    OrderedProductsDto ordered_product_id;
}
