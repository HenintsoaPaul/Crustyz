package mg.crustyz.controller.stock;

import lombok.RequiredArgsConstructor;
import mg.crustyz.service.IngredientStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/stocks/ingredients" )
public class IngredientStockController {
    private final IngredientStockService ingredientStockService;

    @GetMapping
    public String get( Model model ) {
        model.addAttribute( "ingredientStocksList", ingredientStockService.findAll() );
        return "stocks/ingredients/index";
    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id )
            throws Exception {
        model.addAttribute( "stock", ingredientStockService.findById( id ) );
        model.addAttribute( "mvtList", ingredientStockService.findAllMvtById( id ) );
        return "stocks/ingredients/mvt";
    }
}
