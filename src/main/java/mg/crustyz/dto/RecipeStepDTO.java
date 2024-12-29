package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.recipe.RecipeStep;
import mg.crustyz.entity.stock.IngredientStock;


@Data
public class RecipeStepDTO {
    private RecipeStep recipeStep;
    private IngredientStock ingredientStock;

    public RecipeStepDTO( RecipeStep recipeStep, IngredientStock ingredientStock ) {
        this.recipeStep = recipeStep;
        this.ingredientStock = ingredientStock;
    }

}
