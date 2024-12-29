package mg.crustyz.repository.recipe;

import mg.crustyz.entity.recipe.RecipeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeProductRepository extends JpaRepository<RecipeProduct, Integer> {
}
