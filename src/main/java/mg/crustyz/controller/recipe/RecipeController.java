package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.RecipeDTO;
import mg.crustyz.repository.IngredientRepository;
import mg.crustyz.repository.ProductRepository;
import mg.crustyz.service.recipe.RecipeService;
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

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "recipesList", recipeService.findAll() );
        return "recipes/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "productsList", productRepository.findAll() );
        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );
        model.addAttribute( "recipeDTO", new RecipeDTO() );
        return "recipes/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "recipeDTO" ) RecipeDTO recipeDTO )
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
        model.addAttribute( "recipeDTO", recipeService.findDTOById( id ) );
        return "recipes/detail";
    }
}
