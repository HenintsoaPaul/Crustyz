package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "ingredient_provider" )
public class IngredientProvider {
    @Id
    @ColumnDefault( "nextval('ingredient_provider_id_ingredient_provider_seq')" )
    @Column( name = "id_ingredient_provider", nullable = false )
    private Integer id;

    @Column( name = "unit_price", nullable = false, precision = 15, scale = 2 )
    private BigDecimal unitPrice;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private Ingredient idIngredient;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_provider", nullable = false )
    private mg.crustyz.entity.Provider idProvider;

}
