package mg.crustyz.controller.stock;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.stock.MvtIngredientStock;
import mg.crustyz.repository.IngredientRepository;
import mg.crustyz.repository.stock.MvtIngredientStockRepository;
import mg.crustyz.repository.stock.MvtStockTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/stocks/ingredients/mvt" )
public class MvtIngredientStockController {
    private final MvtIngredientStockRepository repo;
    private final IngredientRepository ingredientRepository;
    private final MvtStockTypeRepository mvtStockTypeRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "mvtIngredientStocksList", repo.findAll() );
        return "stocks/ingredients/mvt/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "mvtIngredientStock", new MvtIngredientStock() );
        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );
        model.addAttribute( "mvtStockTypesList", mvtStockTypeRepository.findAll() );
        return "stocks/ingredients/mvt/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "mvtIngredientStock" ) MvtIngredientStock mvtIngredientStock ) {
        repo.save( mvtIngredientStock );
        return "redirect:/stocks/ingredients/mvt";
    }

    @GetMapping( "/update/{id}" )
    public String formNew( Model model, @PathVariable Integer id )
            throws Exception {
        MvtIngredientStock u = repo.findById( id )
                .orElseThrow( () -> new Exception( "MvtIngredientStock not found" ) );
        model.addAttribute( "mvtIngredientStock", u );
        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );
        model.addAttribute( "mvtStockTypesList", mvtStockTypeRepository.findAll() );
        return "stocks/ingredients/mvt/update";
    }
}
