package mg.crustyz.service.recipe;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.RecipeDTO;
import mg.crustyz.dto.form.RecipeFormData;
import mg.crustyz.dto.form.RecipeStepFormData;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.recipe.RecipeStep;
import mg.crustyz.entity.recipe.RecipeStepIngredient;
import mg.crustyz.repository.recipe.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeStepService recipeStepService;
    private final RecipeProductService recipeProductService;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findById( int id )
            throws Exception {
        return recipeRepository.findById( id )
                .orElseThrow( () -> new Exception( "Recipe not found" ) );
    }

    @Transactional
    public void save( RecipeFormData formData )
            throws Exception {
        Recipe recipe = recipeRepository.save( formData.getRecipe() );

        List<RecipeStepFormData> steps = formData.getRecipeSteps();
        for ( int i = 0; i < steps.size(); i++ ) {
            RecipeStep step = steps.get( i ).getRecipeStep();

            List<RecipeStepIngredient> recipeStepIngredientList = steps.get(i).getRsIngredients();
            for ( RecipeStepIngredient rsi : recipeStepIngredientList ) {

            }


            recipeStepService.save( recipe, step, i + 1 );
        }

        for ( RecipeProduct rp: formData.getRecipeProducts() ) {
            recipeProductService.save( recipe, rp );
        }
    }

    public RecipeDTO findDTOById( Integer id )
            throws Exception {
        Recipe recipe = this.findById( id );
        RecipeDTO dto = new RecipeDTO( recipe );
        dto.setRecipeSteps( recipeStepService.findAllByRecipe( recipe ) );
        dto.setRecipeProducts( recipeProductService.findAllByRecipe( recipe ) );
        return dto;
    }
}
