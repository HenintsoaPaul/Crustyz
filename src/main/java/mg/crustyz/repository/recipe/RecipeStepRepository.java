package mg.crustyz.repository.recipe;

import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeStepRepository extends JpaRepository<RecipeStep, Integer> {
    List<RecipeStep> findAllByRecipe( Recipe recipe );
}
