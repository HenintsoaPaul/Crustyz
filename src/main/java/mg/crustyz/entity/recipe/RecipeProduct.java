package mg.crustyz.entity.recipe;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Product;



@Data
@Entity
@Table( name = "recipe_product" )
public class RecipeProduct {
    @EmbeddedId
    private RecipeProductId id;

    @MapsId( "idProduct" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

    @MapsId( "idRecipe" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_recipe", nullable = false )
    private Recipe recipe;

    @Column( name = "quantity_produced", nullable = false )
    private double quantityProduced;

}
