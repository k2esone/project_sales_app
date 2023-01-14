package project.sales.app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime localDateTime;

    private int quantity;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Order order;
}
