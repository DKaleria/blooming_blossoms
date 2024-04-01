package dubovikLera.entity;

import dubovikLera.dto.ProductsDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderedProducts {
    private Orders order_id;
    private ProductsDto product_id;
    private Integer quantity;
    private Integer orders_product_id;


}