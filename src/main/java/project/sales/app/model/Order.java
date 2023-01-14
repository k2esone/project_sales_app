package project.sales.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    LocalDateTime localDateTime;

    @ManyToOne
    private Invoice invoice;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private Set<Return> returns;
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;
}
