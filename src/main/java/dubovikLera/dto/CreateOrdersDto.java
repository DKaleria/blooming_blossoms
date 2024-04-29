package dubovikLera.dto;

import dubovikLera.entity.Customers;
import dubovikLera.entity.enums.StatusDelivery;
import dubovikLera.entity.enums.StatusPayment;
import lombok.Builder;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Value
@Builder
@Valid
public class CreateOrdersDto {
    @NotNull(message = "Order_date must not be null")
    Timestamp order_date;
    StatusPayment status_payment;
    StatusDelivery status_delivery;
    Customers customer_id;

}
