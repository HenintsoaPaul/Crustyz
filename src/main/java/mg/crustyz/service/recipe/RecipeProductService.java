package mg.crustyz.service.recipe;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.RecipeProductDTO;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.recipe.RecipeProductId;
import mg.crustyz.entity.stock.ProductStock;
import mg.crustyz.repository.recipe.RecipeProductRepository;
import mg.crustyz.service.ProductStockService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeProductService {
    private final RecipeProductRepository recipeProductRepository;
    private final ProductStockService productStockService;

    public RecipeProduct findById( RecipeProductId id )
            throws Exception {
        return recipeProductRepository.findById( id )
                .orElseThrow( () -> new Exception( "RecipeProduct not found" ) );
    }

    public RecipeProductDTO findDTOById( RecipeProductId id )
            throws Exception {
        RecipeProduct rp = findById( id );
        ProductStock is = this.productStockService.findByProduct( rp.getProduct() );
        return new RecipeProductDTO( rp, is );
    }

    public List<RecipeProductDTO> findAllDTOByRecipe( Recipe recipe ) {
        List<RecipeProductDTO> dtos = new ArrayList<>();
        this.recipeProductRepository.findAllByRecipe( recipe ).forEach( rs -> {
            try {
                dtos.add( this.findDTOById( rs.getId() ) );
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }
        } );
        return dtos;
    }

    @Transactional
    public void save( Recipe mother, RecipeProduct rp ) {
        RecipeProductId id = new RecipeProductId();
        id.setIdProduct( rp.getProduct().getId() );
        id.setIdRecipe( mother.getId() );
        rp.setId( id );

        rp.setRecipe( mother );
        recipeProductRepository.save( rp );
    }

    public List<RecipeProduct> findAllByRecipe( Recipe recipe ) {
        return recipeProductRepository.findAllByRecipe( recipe );
    }
}
