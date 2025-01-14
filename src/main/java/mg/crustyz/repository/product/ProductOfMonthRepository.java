package mg.crustyz.repository.product;

import mg.crustyz.entity.product.ProductOfMonth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOfMonthRepository extends JpaRepository<ProductOfMonth, Integer> {
}
