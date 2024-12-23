package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "ingredient_stock" )
public class IngredientStock {
    @Id
    @ColumnDefault( "nextval('ingredient_stock_id_ingredient_stock_seq')" )
    @Column( name = "id_ingredient_stock", nullable = false )
    private Integer id;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private Ingredient idIngredient;

}
