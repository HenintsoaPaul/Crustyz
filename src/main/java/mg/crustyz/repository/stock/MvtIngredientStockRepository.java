package mg.crustyz.repository.stock;

import mg.crustyz.entity.stock.MvtIngredientStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtIngredientStockRepository extends JpaRepository<MvtIngredientStock, Integer> {
}
