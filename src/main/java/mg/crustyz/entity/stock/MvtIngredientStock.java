package mg.crustyz.entity.stock;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Ingredient;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table( name = "mvt_ingredient_stock" )
public class MvtIngredientStock {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
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
    private MvtStockType idMvtStockType;

}
