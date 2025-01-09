package mg.crustyz.repository.recipe;

import mg.crustyz.entity.recipe.RecipeStep;
import mg.crustyz.entity.recipe.RecipeStepIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeStepIngredientRepository extends JpaRepository<RecipeStepIngredient, Integer> {
    List<RecipeStepIngredient> findAllByRecipeStep( RecipeStep recipeStep );
}
