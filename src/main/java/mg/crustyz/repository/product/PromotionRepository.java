package mg.crustyz.repository.product;

import mg.crustyz.entity.product.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
}
