package mg.crustyz.entity.recipe;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Ingredient;

@Data
@Entity
@Table( name = "recipe_step_ingredient" )
public class RecipeStepIngredient {
    @EmbeddedId
    private RecipeStepIngredientId id;

    @MapsId( "idIngredient" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private Ingredient ingredient;

    @MapsId( "idRecipeStep" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_recipe_step", nullable = false )
    private RecipeStep recipeStep;

    @Column( name = "quantity_used", nullable = false )
    private double quantityUsed;

}
