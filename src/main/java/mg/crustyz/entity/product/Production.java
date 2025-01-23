package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table( name = "production" )
public class Production {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_production", nullable = false )
    private Integer id;

    @Column( name = "daty", nullable = false )
    private LocalDate daty;

    @Column( name = "quantity", nullable = false )
    private double quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

}
