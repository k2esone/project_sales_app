package project.sales.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @OneToMany(mappedBy = "invoice")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CorrectiveInvoice> correctiveInvoices;

    @OneToMany(mappedBy = "invoice")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Order> orders;
}
