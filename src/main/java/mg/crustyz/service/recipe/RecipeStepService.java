package mg.crustyz.service.recipe;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.RecipeStepDTO;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeStep;
import mg.crustyz.entity.stock.IngredientStock;
import mg.crustyz.repository.recipe.RecipeStepRepository;
import mg.crustyz.service.IngredientStockService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeStepService {
    private final RecipeStepRepository recipeStepRepository;
    private final IngredientStockService ingredientStockService;

    public List<RecipeStep> findAll() {
        return recipeStepRepository.findAll();
    }

    public List<RecipeStep> findAllByRecipe( Recipe recipe ) {
        return recipeStepRepository.findAllByRecipe( recipe );
    }

    public RecipeStep findById( int id )
            throws Exception {
        return recipeStepRepository.findById( id )
                .orElseThrow( () -> new Exception( "RecipeStep not found" ) );
    }

    public RecipeStepDTO findDTOById( int id )
            throws Exception {
        RecipeStep rs = findById( id );
        IngredientStock is = this.ingredientStockService.findByIngredient( rs.getIngredient() );
        return new RecipeStepDTO( rs, is );
    }

    public List<RecipeStepDTO> findAllDTOByRecipe( Recipe recipe ) {
        List<RecipeStepDTO> dtos = new ArrayList<>();
        this.recipeStepRepository.findAllByRecipe( recipe ).forEach( rs -> {
            try {
                dtos.add( this.findDTOById( rs.getId() ) );
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }
        } );
        return dtos;
    }

    @Transactional
    public void save( Recipe mother, RecipeStep step ) {
        step.setRecipe( mother );
        recipeStepRepository.save( step );
    }
}
