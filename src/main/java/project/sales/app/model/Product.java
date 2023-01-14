package project.sales.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String use;

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems;
    @OneToMany(mappedBy = "product")
    private Delivery delivery;

}
