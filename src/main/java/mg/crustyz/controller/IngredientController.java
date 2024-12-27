package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Ingredient;
import mg.crustyz.repository.IngredientRepository;
import mg.crustyz.repository.UnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/ingredients" )
public class IngredientController {
    private final IngredientRepository ingredientRepository;
    private final UnitRepository unitRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );
        return "ingredients/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "unitsList", unitRepository.findAll() );
        model.addAttribute( "ingredient", new Ingredient() );
        return "ingredients/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "ingredient" ) Ingredient ingredient ) {
        ingredientRepository.save( ingredient );
        return "redirect:/ingredients";
    }

    @GetMapping( "/update/{id}" )
    public String gotoUpdate( Model model, @PathVariable Integer id )
            throws Exception {
        Ingredient u = ingredientRepository.findById( id )
                .orElseThrow( () -> new Exception( "Ingredient not found" ) );
        model.addAttribute( "ingredient", u );
        model.addAttribute( "unitsList", unitRepository.findAll() );
        return "ingredients/update";
    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id )
            throws Exception {
        Ingredient u = ingredientRepository.findById( id )
                .orElseThrow( () -> new Exception( "Ingredient not found" ) );
        model.addAttribute( "ingredient", u );
        return "ingredients/detail";
    }
}
