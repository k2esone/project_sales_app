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
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    LocalDateTime localDateTime;

    @OneToMany(mappedBy = "invoice")
    private Set<CorrectiveInvoice> correctiveInvoices;
    @OneToMany(mappedBy = "invoice")
    private Set<Order> orders;
}
