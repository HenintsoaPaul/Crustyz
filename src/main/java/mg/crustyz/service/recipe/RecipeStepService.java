package mg.crustyz.service.recipe;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeStep;
import mg.crustyz.repository.recipe.RecipeStepRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeStepService {
    private final RecipeStepRepository recipeStepRepository;

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

    @Transactional
    public void save( Recipe mother, RecipeStep step )
            throws Exception {
        step.setRecipe( mother );
        recipeStepRepository.save( step );
    }
}
