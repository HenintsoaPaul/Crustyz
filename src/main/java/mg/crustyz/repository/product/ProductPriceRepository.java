package mg.crustyz.repository.product;

import mg.crustyz.entity.product.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {
}
