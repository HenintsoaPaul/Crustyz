package mg.crustyz.service.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.PromotionDTO;
import mg.crustyz.entity.product.Promotion;
import mg.crustyz.repository.product.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;
    private final ProductPromotionService productPromotionService;

    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Transactional
    public void save( PromotionDTO promotionDTO )
            throws Exception {
        Promotion mother = promotionRepository.save( promotionDTO.getPromotion() );
        promotionDTO.getProductPromotions().forEach( pp -> {
            productPromotionService.save( mother, pp );
        } );
    }

    public Promotion findById( Integer id )
            throws Exception {
        return promotionRepository.findById( id )
                .orElseThrow( () -> new Exception( "Promotion not found" ) );
    }
}
