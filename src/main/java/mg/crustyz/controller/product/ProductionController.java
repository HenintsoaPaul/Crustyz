package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Ingredient;
import mg.crustyz.entity.product.Product;
import mg.crustyz.entity.product.Production;
import mg.crustyz.repository.IngredientRepository;
import mg.crustyz.repository.product.ProductRepository;
import mg.crustyz.repository.product.ProductionRepository;
import mg.crustyz.service.product.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/products/productions" )
public class ProductionController {
    private final ProductionRepository productionRepository;
    private final IngredientRepository ingredientRepository;
    private final ProductRepository productRepository;
    private final ProductionService productionService;

    @GetMapping
    public String getAll( Model model, @RequestParam(required = false) List<Integer> selectedIngredients ) {
        List<Production> productions = productionService.findAll();
        List<Ingredient> ingredients = ingredientRepository.findAll();

        if (selectedIngredients != null && !selectedIngredients.isEmpty()) {
            productions = productionService.filterByIngredients(selectedIngredients);
        }

        model.addAttribute( "productionsList", productions );
        model.addAttribute( "ingredientsList", ingredients );

        return "products/productions/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "production", new Production() );

        List<Product> products = productRepository.findAll();
        model.addAttribute( "productsList", products );

        return "products/productions/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "production" ) Production production ) {
        productionRepository.save( production );
        return "redirect:/products/productions";
    }
}
