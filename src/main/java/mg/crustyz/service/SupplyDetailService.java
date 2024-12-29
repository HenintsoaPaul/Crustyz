package mg.crustyz.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.supply.Supply;
import mg.crustyz.entity.supply.SupplyDetail;
import mg.crustyz.repository.supply.SupplyDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyDetailService {
    private final SupplyDetailRepository supplyDetailRepository;
    private final IngredientStockService ingredientStockService;

    @Transactional
    public void save( Supply mother, SupplyDetail supplyDetail )
            throws Exception {
        double price = supplyDetail.getIngredientProvider().getUnitPrice() * supplyDetail.getQuantity();
        supplyDetail.setPrice( price );

        supplyDetail.setSupply( mother );
        ingredientStockService.saveMvtStock( supplyDetail );

        supplyDetailRepository.save( supplyDetail );
    }

    public List<SupplyDetail> findAllBySupply( Supply supply ) {
        return supplyDetailRepository.findAllBySupply( supply );
    }
}
