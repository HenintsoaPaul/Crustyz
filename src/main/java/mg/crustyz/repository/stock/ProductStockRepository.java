package mg.crustyz.repository.stock;

import mg.crustyz.entity.stock.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {
}
