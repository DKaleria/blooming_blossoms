package dubovikLera.mapper;

import dubovikLera.dto.CreateCustomersDto;
import dubovikLera.dto.CreateOrdersDto;
import dubovikLera.entity.Customers;
import dubovikLera.entity.Orders;

public class CreateCustomersMapper  implements Mapper<Customers, CreateCustomersDto> {
    @Override
    public Customers mapFrom(CreateCustomersDto customers) {
        return Customers.builder()
                .first_name(customers.getFirst_name())
                .last_name(customers.getLast_name())
                .delivery_address(customers.getDelivery_address())
                .contact_details(customers.getContact_details())
                .build();
    }
}
