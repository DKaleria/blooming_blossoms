package dubovikLera.mapper;

import dubovikLera.dto.CreateOrdersDto;
import dubovikLera.entity.Orders;

public class CreateOrdersMapper  implements Mapper<Orders, CreateOrdersDto> {
    @Override
    public Orders mapFrom(CreateOrdersDto orders) {
        return Orders.builder()
                .order_date(orders.getOrder_date())
                .status_payment(orders.getStatus_payment())
                .status_delivery(orders.getStatus_delivery())
                .customer_id(orders.getCustomer_id())
                .build();
    }
}
