package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table( name = "sale" )
public class Sale {
    @Id
    @ColumnDefault( "nextval('sale_id_sale_seq')" )
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
