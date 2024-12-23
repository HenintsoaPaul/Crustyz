package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "product_stock" )
public class ProductStock {
    @Id
    @ColumnDefault( "nextval('product_stock_id_stock_product_seq')" )
    @Column( name = "id_stock_product", nullable = false )
    private Integer id;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

}
