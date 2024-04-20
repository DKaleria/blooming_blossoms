package dubovikLera.entity;

import dubovikLera.dto.ProductsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ordered_products")
public class OrderedProducts {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product_id;

    @Column(nullable = false)
    private Integer quantity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orders_product_id;

    @OneToOne(mappedBy = "ordered_product_id", cascade = CascadeType.ALL)
    private Reviews reviews;


}