package dubovikLera.dto;

import dubovikLera.entity.Customers;
import dubovikLera.entity.Products;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Value
@Builder
public class FavoritesDto {
    Integer favorite_id;
    Timestamp date_added;
    CustomersDto customer_id;
    ProductsDto product_id;

}
