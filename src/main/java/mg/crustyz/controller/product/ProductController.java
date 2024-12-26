package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Product;
import mg.crustyz.repository.ProductCategoryRepository;
import mg.crustyz.repository.ProductRepository;
import mg.crustyz.repository.UnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/products" )
public class ProductController {
    private final ProductRepository productRepository;
    private final UnitRepository unitRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "productsList", productRepository.findAll() );
        return "products/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "unitsList", unitRepository.findAll() );
        model.addAttribute( "categoriesList", productCategoryRepository.findAll() );
        model.addAttribute( "product", new Product() );
        return "products/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "product" ) Product product ) {
        productRepository.save( product );
        return "redirect:/products";
    }

    @GetMapping( "/update/{id}" )
    public String formNew( Model model, @PathVariable Integer id )
            throws Exception {
        Product u = productRepository.findById( id )
                .orElseThrow( () -> new Exception( "Product not found" ) );
        model.addAttribute( "product", u );
        model.addAttribute( "unitsList", unitRepository.findAll() );
        model.addAttribute( "categoriesList", productCategoryRepository.findAll() );
        return "products/update";
    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id )
            throws Exception {
        Product u = productRepository.findById( id )
                .orElseThrow( () -> new Exception( "Product not found" ) );
        model.addAttribute( "product", u );
        return "products/detail";
    }
}
