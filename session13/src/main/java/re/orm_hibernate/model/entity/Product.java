package re.orm_hibernate.model.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(255) not null unique")
    private String name;
    private String description;
    @ManyToOne()
    private Shop shop;

}
