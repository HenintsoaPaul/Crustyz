package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.recipe.RecipeStep;

import java.util.ArrayList;
import java.util.List;


@Data
public class RecipeDTO {
    private Recipe recipe;
    private List<RecipeStep> recipeSteps = new ArrayList<>();
    private List<RecipeProduct> recipeProducts = new ArrayList<>();

    public RecipeDTO() {
        this.recipeSteps.add( new RecipeStep() );
        this.recipeProducts.add( new RecipeProduct() );
    }
}
