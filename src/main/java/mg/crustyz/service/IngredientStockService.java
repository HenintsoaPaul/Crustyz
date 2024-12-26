package mg.crustyz.service;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.stock.IngredientStock;
import mg.crustyz.entity.stock.MvtIngredientStock;
import mg.crustyz.repository.stock.IngredientStockRepository;
import mg.crustyz.repository.stock.MvtIngredientStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientStockService {
    private final IngredientStockRepository ingredientStockRepository;
    private final MvtIngredientStockRepository mvtIngredientStockRepository;

    public List<IngredientStock> findAll() {
        return ingredientStockRepository.findAll();
    }

    public IngredientStock findById( int id )
            throws Exception {
        return ingredientStockRepository.findById( id )
                .orElseThrow( () -> new Exception( "IngredientStock not found" ) );
    }

    public List<MvtIngredientStock> findAllMvtById( int id ) {
        return mvtIngredientStockRepository.getByIdIngredientStock( id );
    }
}
