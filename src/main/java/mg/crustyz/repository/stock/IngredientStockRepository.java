package mg.crustyz.repository.stock;

import mg.crustyz.entity.stock.IngredientStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientStockRepository extends JpaRepository<IngredientStock, Integer> {
}
