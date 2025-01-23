package mg.crustyz.dto.form;

import lombok.Data;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.recipe.RecipeStep;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeFormData {
//    private Recipe recipe;
//    private List<RecipeStep> recipeSteps = new ArrayList<>();
//    private List<RecipeProduct> recipeProducts = new ArrayList<>();
//
//    public RecipeFormData() {
//        this.recipeSteps.add( new RecipeStep() );
//        this.recipeProducts.add( new RecipeProduct() );
//    }
//
//    public RecipeFormData( Recipe recipe ) {
//        this.recipe = recipe;
//    }

    private Recipe recipe;
    private List<RecipeStepFormData> recipeSteps = new ArrayList<>();
    private List<RecipeProduct> recipeProducts = new ArrayList<>();

    public RecipeFormData() {
        this.recipeSteps.add( new RecipeStepFormData() );
        this.recipeProducts.add( new RecipeProduct() );
    }
}
