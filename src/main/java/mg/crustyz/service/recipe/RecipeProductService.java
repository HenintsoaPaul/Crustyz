package mg.crustyz.service.recipe;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.recipe.RecipeProductId;
import mg.crustyz.repository.recipe.RecipeProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeProductService {
    private final RecipeProductRepository recipeProductRepository;

    public List<RecipeProduct> findAll() {
        return recipeProductRepository.findAll();
    }

    public RecipeProduct findById( int id )
            throws Exception {
        return recipeProductRepository.findById( id )
                .orElseThrow( () -> new Exception( "RecipeProduct not found" ) );
    }

    @Transactional
    public void save( Recipe mother, RecipeProduct rp )
            throws Exception {
        RecipeProductId id = new RecipeProductId();
        id.setIdProduct( rp.getProduct().getId() );
        id.setIdRecipe( mother.getId() );
        rp.setId( id );

        rp.setRecipe( mother );
        recipeProductRepository.save( rp );
    }
}
