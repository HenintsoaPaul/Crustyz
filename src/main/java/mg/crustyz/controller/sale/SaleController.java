package mg.crustyz.controller.sale;

import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.SaleDTO;
import mg.crustyz.service.ProductStockService;
import mg.crustyz.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/sales" )
public class SaleController {
    private final SaleService saleService;
    private final ProductStockService productStockService;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "salesList", saleService.findAll() );
        return "sales/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "productStocksList", productStockService.findAll() );
        model.addAttribute( "saleDTO", new SaleDTO() );
        return "sales/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "saleDTO" ) SaleDTO saleDTO )
            throws Exception {
        saleService.save( saleDTO );
        return "redirect:/sales";
    }

//    @GetMapping( "/{id}" )
//    public String detail( Model model, @PathVariable Integer id )
//            throws Exception {
//        Sale u = saleRepository.findById( id )
//                .orElseThrow( () -> new Exception( "Sale not found" ) );
//        model.addAttribute( "sale", u );
//        return "sales/detail";
//    }
}
