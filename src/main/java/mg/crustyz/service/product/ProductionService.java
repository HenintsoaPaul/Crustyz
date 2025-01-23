package mg.crustyz.service.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Product;
import mg.crustyz.entity.product.Production;
import mg.crustyz.repository.product.ProductRepository;
import mg.crustyz.repository.product.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionService {
    private final ProductionRepository productionRepository;
    private final ProductRepository productRepository;

    public List<Production> findAll() {
        return productionRepository.findAll();
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void save( Production production )
            throws Exception {
        // TODO: miteraka mouvement de Stocks: ingredients + products ito zavatra ito
        // ....

        productionRepository.save( production );
    }

    public List<Production> filterByIngredients( List<Integer> ingredientIds ) {
        if (ingredientIds == null || ingredientIds.isEmpty()) {
            return findAll();
        }

        return productionRepository.findByIngredientsIn(ingredientIds);
    }

    public List<Production> filterByProducts(List<Integer> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            return findAll();
        }

        return productionRepository.findByProductsIn(productIds);
    }
}
