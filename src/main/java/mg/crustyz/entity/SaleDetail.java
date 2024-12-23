package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "sale_detail" )
public class SaleDetail {
    @Id
    @ColumnDefault( "nextval('sale_detail_id_sale_detail_seq')" )
    @Column( name = "id_sale_detail", nullable = false )
    private Integer id;

    @Column( name = "quantity", precision = 15, scale = 2 )
    private BigDecimal quantity;

    @Column( name = "price", precision = 15, scale = 2 )
    private BigDecimal price;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_sale", nullable = false )
    private Sale idSale;

}
