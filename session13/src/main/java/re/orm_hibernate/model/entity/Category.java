package re.orm_hibernate.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "join_table",joinColumns = @JoinColumn(name = "category_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
