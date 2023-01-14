package project.sales.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private double price;

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Product product;

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order order;
}
