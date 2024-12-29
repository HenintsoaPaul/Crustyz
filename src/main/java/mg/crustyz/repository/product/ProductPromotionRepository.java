package mg.crustyz.repository.product;

import mg.crustyz.entity.product.ProductPromotion;
import mg.crustyz.entity.product.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, Integer> {
    List<ProductPromotion> findProductPromotionByPromotion( Promotion promotion );
}
