package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.ProductPrice;
import mg.crustyz.repository.product.ProductPriceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/products/prices" )
public class ProductPriceController {
    private final ProductPriceRepository productPriceRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "productPrices", productPriceRepository.findAll() );
        return "products/prices/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "productPrice", new ProductPrice() );
        return "products/prices/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "productPrice" ) ProductPrice productPrice ) {
        productPriceRepository.save( productPrice );
        return "redirect:/products/prices";
    }

    @GetMapping( "/update/{id}" )
    public String formNew( Model model, @PathVariable Integer id )
            throws Exception {
        ProductPrice u = productPriceRepository.findById( id )
                .orElseThrow( () -> new Exception( "ProductPrice not found" ) );
        model.addAttribute( "productPrice", u );
        return "products/prices/update";
    }
}
