package dubovikLera.dto;

import dubovikLera.entity.Customers;
import dubovikLera.entity.OrderedProducts;
import dubovikLera.entity.enums.StatusDelivery;
import dubovikLera.entity.enums.StatusPayment;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class OrdersDto {
    Integer order_id;
    Timestamp order_date;
    StatusPayment status_payment;
    StatusDelivery status_delivery;
    Customers customer_id;
    List<OrderedProducts> ordered_products = new ArrayList<>();
}
