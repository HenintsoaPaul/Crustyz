package mg.crustyz.dto.form;

import lombok.Data;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.recipe.RecipeStep;
import mg.crustyz.entity.recipe.RecipeStepIngredient;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeStepFormData {
//    private Recipe recipe;
//    private List<RecipeStep> recipeSteps = new ArrayList<>();
//    private List<RecipeProduct> recipeProducts = new ArrayList<>();

    private RecipeStep recipeStep;
    private List<RecipeStepIngredient> rsIngredients = new ArrayList<>();

    public RecipeStepFormData() {
        this.rsIngredients.add( new RecipeStepIngredient() );
    }
}
