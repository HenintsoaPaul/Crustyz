package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "baked_ingredient" )
public class BakedIngredient {
    @EmbeddedId
    private BakedIngredientId id;

    @MapsId( "idIngredient" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private mg.crustyz.entity.Ingredient idIngredient;

    @MapsId( "idBaking" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_baking", nullable = false )
    private mg.crustyz.entity.Baking idBaking;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

}
