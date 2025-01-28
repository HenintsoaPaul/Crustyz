package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table( name = "product_price" )
public class ProductPrice {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_product_price", nullable = false )
    private Integer id;

    @Column( name = "add_date", nullable = false, length = 50 )
    private LocalDate addDate;

    @Column( name = "val", nullable = false, length = 50 )
    private double val;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

}
