package dubovikLera.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Data
@Builder
public class ProductsDto {
    private Integer productId;
    private String name;
    private BigDecimal price;
    private String image;
    private CategoriesDto categories;
    private String description;
    private boolean availability;
    private int quantityInStock;
}