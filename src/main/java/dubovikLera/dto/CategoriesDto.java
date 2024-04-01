package dubovikLera.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CategoriesDto {
    private Integer categoryId;
    private String name;


}
