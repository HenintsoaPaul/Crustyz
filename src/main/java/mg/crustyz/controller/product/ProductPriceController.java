package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.ProductPrice;
import mg.crustyz.service.product.ProductPriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/products/prices" )
public class ProductPriceController {
    private final ProductPriceService productPriceService;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "productPrices", productPriceService.findAll() );
        return "products/prices/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "productPrice", new ProductPrice() );
        model.addAttribute( "productList", productPriceService.findAllProduct() );
        return "products/prices/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "productPrice" ) ProductPrice productPrice ) throws Exception {
        productPriceService.save( productPrice );
        return "redirect:/products/prices";
    }

    @GetMapping( "/update/{id}" )
    public String formNew( Model model, @PathVariable Integer id )
            throws Exception {
        model.addAttribute( "productPrice", productPriceService.findById( id ) );
        return "products/prices/update";
    }
}
