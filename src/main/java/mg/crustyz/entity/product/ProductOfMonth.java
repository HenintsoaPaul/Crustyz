package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table( name = "product_of_month" )
public class ProductOfMonth {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_product_of_month", nullable = false )
    private Integer id;

    @Column( name = "add_date", nullable = false )
    private LocalDate addDate;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

}
