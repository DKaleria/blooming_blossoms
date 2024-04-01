package dubovikLera.entity;

import dubovikLera.dto.ProductsDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Favorites {
    private Integer favorite_id;
    private Timestamp date_added;
    private Customers customer_id;
    private ProductsDto product_id;

}
