package dubovikLera.entity;

import dubovikLera.dto.ProductsDto;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"order_id", "product_id"})
@Table(name = "ordered_products")
public class OrderedProducts extends AbstractEntity<Integer> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order_id;

    @ManyToOne(fetch = FetchType.LAZY)
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