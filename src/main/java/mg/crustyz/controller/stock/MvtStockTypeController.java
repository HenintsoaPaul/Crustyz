package mg.crustyz.controller.stock;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.stock.MvtStockType;
import mg.crustyz.repository.stock.MvtStockTypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/stocks/mvtStockTypes" )
public class MvtStockTypeController {
    private final MvtStockTypeRepository mvtStockTypeRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "mvtStockTypesList", mvtStockTypeRepository.findAll() );
        return "stocks/mvtStockTypes/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "mvtStockType", new MvtStockType() );
        return "stocks/mvtStockTypes/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "mvtStockType" ) MvtStockType mvtStockType ) {
        mvtStockTypeRepository.save( mvtStockType );
        return "redirect:/stocks/mvtStockTypes";
    }

    @GetMapping( "/update/{id}" )
    public String formNew( Model model, @PathVariable Integer id )
            throws Exception {
        MvtStockType u = mvtStockTypeRepository.findById( id )
                .orElseThrow( () -> new Exception( "MvtStockType not found" ) );
        model.addAttribute( "mvtStockType", u );
        return "stocks/mvtStockTypes/update";
    }
}
