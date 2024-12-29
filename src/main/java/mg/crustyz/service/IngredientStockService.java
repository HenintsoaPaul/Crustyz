package mg.crustyz.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.CrustyzProperties;
import mg.crustyz.entity.product.Ingredient;
import mg.crustyz.entity.supply.SupplyDetail;
import mg.crustyz.entity.stock.IngredientStock;
import mg.crustyz.entity.stock.MvtIngredientStock;
import mg.crustyz.entity.stock.MvtStockType;
import mg.crustyz.repository.stock.IngredientStockRepository;
import mg.crustyz.repository.stock.MvtIngredientStockRepository;
import mg.crustyz.repository.stock.MvtStockTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientStockService {
    private final IngredientStockRepository ingredientStockRepository;
    private final MvtIngredientStockRepository mvtIngredientStockRepository;
    private final MvtStockTypeRepository mvtStockTypeRepository;

    private final CrustyzProperties properties;

    public List<IngredientStock> findAll() {
        return ingredientStockRepository.findAll();
    }

    public IngredientStock findById( int id )
            throws Exception {
        return ingredientStockRepository.findById( id )
                .orElseThrow( () -> new Exception( "IngredientStock not found" ) );
    }

    public List<MvtIngredientStock> findAllMvtByIdIngredient( int id ) {
        return mvtIngredientStockRepository.getByIdIngredient( id );
    }

    @Transactional
    public void saveMvtStock( SupplyDetail supplyDetail )
            throws Exception {
        MvtIngredientStock mvt = new MvtIngredientStock();
        mvt.setQuantity( supplyDetail.getQuantity() );
        mvt.setIngredient( supplyDetail.getIngredientProvider().getIngredient() );
        mvt.setDaty( supplyDetail.getSupply().getDaty() );

        int idEntree = properties.getIdMvtEntree();
        MvtStockType type = mvtStockTypeRepository.findById( idEntree )
                .orElseThrow( () -> new Exception( "MvtStockType not found" ) );
        mvt.setMvtStockType( type );

        mvtIngredientStockRepository.save( mvt );
    }

    public IngredientStock findByIngredient( Ingredient ingredient )
            throws Exception {
        return this.ingredientStockRepository.findByIngredient( ingredient )
                .orElseThrow( () -> new Exception( "IngredientStock not found" ) );
    }
}
