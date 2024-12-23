package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table( name = "mvt_product_stock" )
public class MvtProductStock {
    @Id
    @ColumnDefault( "nextval('mvt_product_stock_id_mvt_product_stock_seq')" )
    @Column( name = "id_mvt_product_stock", nullable = false )
    private Integer id;

    @Column( name = "daty", nullable = false )
    private LocalDate daty;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private mg.crustyz.entity.Product idProduct;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_mvt_stock_type", nullable = false )
    private mg.crustyz.entity.MvtStockType idMvtStockType;

}
