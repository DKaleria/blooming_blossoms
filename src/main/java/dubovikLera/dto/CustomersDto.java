package dubovikLera.dto;

import dubovikLera.entity.Favorites;
import dubovikLera.entity.Orders;
import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class CustomersDto {
    Integer customer_id;
    String first_name;
    String last_name;
    String delivery_address;
    String contact_details;
}
