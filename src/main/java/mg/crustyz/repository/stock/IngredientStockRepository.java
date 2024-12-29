package mg.crustyz.repository.stock;

import mg.crustyz.entity.product.Ingredient;
import mg.crustyz.entity.stock.IngredientStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientStockRepository extends JpaRepository<IngredientStock, Integer> {
    Optional<IngredientStock> findByIngredient( Ingredient ingredient );
}
