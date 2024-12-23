package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "recipe_product" )
public class RecipeProduct {
    @EmbeddedId
    private RecipeProductId id;

    @MapsId( "idProduct" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

    @MapsId( "idRecipe" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_recipe", nullable = false )
    private Recipe idRecipe;

    @Column( name = "quantity_produced", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantityProduced;

}
