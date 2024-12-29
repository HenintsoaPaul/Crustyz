package mg.crustyz.service.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.ProductPromotion;
import mg.crustyz.entity.product.ProductPromotionId;
import mg.crustyz.entity.product.Promotion;
import mg.crustyz.repository.product.ProductPromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPromotionService {
    private final ProductPromotionRepository productPromotionRepository;

    public List<ProductPromotion> findAllByPromotion( Promotion promotion ) {
        return productPromotionRepository.findProductPromotionByPromotion( promotion );
    }

    @Transactional
    public void save( Promotion mother, ProductPromotion pp ) {
        ProductPromotionId id = new ProductPromotionId();
        id.setIdProduct( pp.getProduct().getId() );
        id.setIdPromotion( mother.getId() );

        pp.setId( id );
        pp.setPromotion( mother );
        productPromotionRepository.save( pp );
    }
}
