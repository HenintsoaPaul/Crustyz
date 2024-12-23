package mg.crustyz.entity.sale;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table( name = "sale" )
public class Sale {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_sale", nullable = false )
    private Integer id;

    @Column( name = "daty", nullable = false )
    private Instant daty;

    @Column( name = "total_price", nullable = false, precision = 15, scale = 2 )
    private BigDecimal totalPrice;

    @ColumnDefault( "'anonymous'" )
    @Column( name = "customer_name", length = 50 )
    private String customerName;

}
