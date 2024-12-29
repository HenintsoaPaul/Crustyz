package mg.crustyz.controller.supply;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.supply.IngredientProvider;
import mg.crustyz.repository.IngredientRepository;
import mg.crustyz.repository.ProviderRepository;
import mg.crustyz.repository.supply.IngredientProviderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/providers/ingredients" )
public class IngredientProviderController {
    private final IngredientProviderRepository ingredientProviderRepository;
    private final IngredientRepository ingredientRepository;
    private final ProviderRepository providerRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "ingredientProvidersList", ingredientProviderRepository.findAll() );
        return "providers/ingredients/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "ingredientProvider", new IngredientProvider() );
        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );
        model.addAttribute( "providersList", providerRepository.findAll() );
        return "providers/ingredients/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "ingredientProvider" ) IngredientProvider ingredientProvider ) {
        ingredientProviderRepository.save( ingredientProvider );
        return "redirect:/providers/ingredients";
    }

//    @GetMapping( "/{id}" )
//    public String detail( Model model, @PathVariable Integer id )
//            throws Exception {
//        IngredientProvider elmt = ingredientProviderRepository.findById( id )
//                .orElseThrow( () -> new Exception( "IngredientProvider not found" ) );
//        model.addAttribute( "ingredientProvider", elmt );
//        return "providers/ingredients/detail";
//    }
}
