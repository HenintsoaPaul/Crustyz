package mg.crustyz.service.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Production;
import mg.crustyz.repository.product.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionService {
    private final ProductionRepository productionRepository;

    public List<Production> findAll() {
        return productionRepository.findAll();
    }

    @Transactional
    public void save( Production production )
            throws Exception {
        productionRepository.save( production );
    }

    public List<Production> filterByIngredients( List<Integer> ingredientIds ) {
        if (ingredientIds == null || ingredientIds.isEmpty()) {
            return findAll();
        }

        return productionRepository.findByIngredientsIn(ingredientIds);
    }
}
