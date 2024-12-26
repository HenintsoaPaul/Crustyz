package mg.crustyz.controller.stock;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.stock.IngredientStock;
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
        IngredientStock ingredientStock = ingredientStockService.findById( id );
        int idIngredient = ingredientStock.getIngredient().getId();

        model.addAttribute( "stock", ingredientStock );
        model.addAttribute( "mvtList", ingredientStockService.findAllMvtByIdIngredient( idIngredient ) );
        return "stocks/ingredients/mvt";
    }
}
