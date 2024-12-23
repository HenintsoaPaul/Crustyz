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
@Table( name = "mvt_ingredient_stock" )
public class MvtIngredientStock {
    @Id
    @ColumnDefault( "nextval('mvt_ingredient_stock_id_mvt_ingredient_stock_seq')" )
    @Column( name = "id_mvt_ingredient_stock", nullable = false )
    private Integer id;

    @Column( name = "daty", nullable = false )
    private LocalDate daty;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private Ingredient idIngredient;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_mvt_stock_type", nullable = false )
    private mg.crustyz.entity.MvtStockType idMvtStockType;

}
