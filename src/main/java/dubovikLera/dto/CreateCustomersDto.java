package dubovikLera.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateCustomersDto {
    String first_name;
    String last_name;
    String delivery_address;
    String contact_details;
}
