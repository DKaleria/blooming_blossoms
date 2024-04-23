package dubovikLera.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name" )
@Builder
@Entity
@ToString(exclude = {"favorites", "orderedProducts", "category_id"})
@Table(name = "products")
public class Products extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    @Column(nullable = false)
    private String name;

    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Boolean availability;

    private String image;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Categories category_id;

    @Column(nullable = false)
    private Integer quantity_in_stock;

    @Builder.Default
    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY)
    private List<Favorites> favorites = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY)
    private List<OrderedProducts> orderedProducts = new ArrayList<>();
}
