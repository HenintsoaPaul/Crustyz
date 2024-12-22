package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "stock" )
public class Stock {
    @Id
    @ColumnDefault( "nextval('stock_id_stock_seq')" )
    @Column( name = "id_stock", nullable = false )
    private Integer id;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private Ingredient idIngredient;

}
