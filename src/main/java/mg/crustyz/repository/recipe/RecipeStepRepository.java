package mg.crustyz.repository.recipe;

import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeStepRepository extends JpaRepository<RecipeStep, Integer> {
    @Query( "SELECT r_step " +
            "FROM RecipeStep r_step " +
            "WHERE r_step.recipe = :recipe" )
    List<RecipeStep> findAllByRecipe( @Param( "recipe" ) Recipe recipe );
}
