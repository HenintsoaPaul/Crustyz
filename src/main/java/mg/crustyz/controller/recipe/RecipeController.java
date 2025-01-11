package mg.crustyz.controller.recipe;

import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.RecipeDTO;
import mg.crustyz.dto.form.RecipeFormData;
import mg.crustyz.entity.recipe.Recipe;
import mg.crustyz.repository.IngredientRepository;
import mg.crustyz.repository.product.ProductRepository;
import mg.crustyz.service.recipe.RecipeProductService;
import mg.crustyz.service.recipe.RecipeService;
import mg.crustyz.service.recipe.RecipeStepService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/recipes" )
public class RecipeController {
    private final RecipeService recipeService;
    private final IngredientRepository ingredientRepository;
    private final ProductRepository productRepository;
    private final RecipeStepService recipeStepService;
    private final RecipeProductService recipeProductService;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "recipesList", recipeService.findAll() );
        return "recipes/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "productsList", productRepository.findAll() );
        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );

        model.addAttribute( "recipeDTO", new RecipeFormData() );
//        model.addAttribute( "recipeDTO", new RecipeDTO() );
        return "recipes/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "recipeDTO" ) RecipeFormData recipeDTO )
            throws Exception {
        recipeService.save( recipeDTO );
        return "redirect:/recipes";
    }

    @GetMapping( "/update/{id}" )
    public String gotoUpdate( Model model, @PathVariable Integer id )
            throws Exception {
        model.addAttribute( "recipeDTO", recipeService.findDTOById( id ) );
        model.addAttribute( "productsList", productRepository.findAll() );
        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );
        return "recipes/update";
    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id )
            throws Exception {
        Recipe recipe = recipeService.findById( id );
        model.addAttribute( "recipe", recipe );
        model.addAttribute( "recipeSteps", recipeStepService.findAllByRecipe( recipe ) );
//        model.addAttribute( "recipeStepDTOs", recipeStepService.findAllDTOByRecipe( recipe ) );
        model.addAttribute( "recipeProductDTOs", recipeProductService.findAllDTOByRecipe( recipe ) );
        return "recipes/detail";
    }
}
