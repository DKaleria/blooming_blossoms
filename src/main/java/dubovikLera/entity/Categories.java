package dubovikLera.entity;

import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "products")
@EqualsAndHashCode(of = "name")
@Builder
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "category_id", cascade = CascadeType.ALL)
    private Products products;

}
