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
    private final IngredientRepository ingredientRepository;
    private final ProductionService productionService;

    @GetMapping
    public String getAll( Model model,
            @RequestParam(required = false) List<Integer> selectedIngredients,
            @RequestParam(required = false) List<Integer> selectedProducts
    ) {
        List<Production> productions = productionService.findAll();
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<Product> products = productionService.findAllProducts();

        if (selectedIngredients != null && !selectedIngredients.isEmpty()) {
            productions = productionService.filterByIngredients(selectedIngredients);
        }
        if (selectedProducts != null && !selectedProducts.isEmpty()) {
            productions = productionService.filterByProducts(selectedProducts);
        }

        model.addAttribute( "productionsList", productions );
        model.addAttribute( "ingredientsList", ingredients );
        model.addAttribute( "productsList", products );

        return "products/productions/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "production", new Production() );

        List<Product> products = productionService.findAllProducts();
        model.addAttribute( "productsList", products );

        return "products/productions/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "production" ) Production production ) throws Exception {
        productionService.save( production );
        return "redirect:/products/productions";
    }
}
