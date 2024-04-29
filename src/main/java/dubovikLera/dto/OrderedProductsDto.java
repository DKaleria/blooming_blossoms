package dubovikLera.dto;

import dubovikLera.dao.OrdersDao;
import dubovikLera.entity.Orders;
import dubovikLera.entity.Products;
import dubovikLera.entity.Reviews;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderedProductsDto {
    Orders order_id;
    Products product_id;
    Integer quantity;
    Integer orders_product_id;
    ReviewsDto reviews;

}
