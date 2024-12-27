package mg.crustyz.controller.supply;

import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.SupplyDTO;
import mg.crustyz.entity.supply.Supply;
import mg.crustyz.repository.supply.IngredientProviderRepository;
import mg.crustyz.service.SupplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/supplies" )
public class SupplyController {
    private final SupplyService supplyService;
    private final IngredientProviderRepository ingredientProviderRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "suppliesList", supplyService.findAll() );
        return "supplies/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "supplyDTO", new SupplyDTO() );
        model.addAttribute( "ingredientProvidersList", ingredientProviderRepository.findAll() );
        return "supplies/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "supplyDTO" ) SupplyDTO supplyDTO )
            throws Exception {
        supplyService.save( supplyDTO );
        return "redirect:/supplies";
    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id ) {
        Supply supply = supplyService.findById( id );
        model.addAttribute( "supply", supply );
        model.addAttribute( "supplyDetailsList", supplyService.findAllDetails( supply ) );
        return "supplies/detail";
    }
}
