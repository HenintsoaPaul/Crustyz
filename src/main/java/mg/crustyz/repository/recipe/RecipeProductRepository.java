package mg.crustyz.repository.recipe;

import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.recipe.RecipeProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeProductRepository extends JpaRepository<RecipeProduct, Integer> {
    List<RecipeProduct> findAllByRecipe( Recipe recipe );

    Optional<RecipeProduct> findById( RecipeProductId id );
}
