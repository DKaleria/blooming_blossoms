package dubovikLera.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.tool.schema.extract.spi.TableInformation;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reviews")
public class Reviews extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer review_id;
    private String comment;
    @Column(nullable = false, precision = 2, scale = 0)
    private Integer rating;
    @Column(nullable = false)
    private Timestamp date;

    @OneToOne
    @JoinColumn(name = "ordered_product_id")
    private OrderedProducts ordered_product_id;
}
