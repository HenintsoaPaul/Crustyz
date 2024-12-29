package mg.crustyz.repository.stock;

import mg.crustyz.entity.product.Product;
import mg.crustyz.entity.stock.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {
    Optional<ProductStock> findByProduct( Product product );
}
