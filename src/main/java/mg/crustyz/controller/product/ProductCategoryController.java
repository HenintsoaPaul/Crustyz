package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.ProductCategory;
import mg.crustyz.repository.product.ProductCategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/products/categories" )
public class ProductCategoryController {
    private final ProductCategoryRepository productCategoryRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "categoriesList", productCategoryRepository.findAll() );
        return "products/categories/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "category", new ProductCategory() );
        return "products/categories/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "category" ) ProductCategory category ) {
        productCategoryRepository.save( category );
        return "redirect:/products/categories";
    }

    @GetMapping( "/update/{id}" )
    public String formNew( Model model, @PathVariable Integer id )
            throws Exception {
        ProductCategory u = productCategoryRepository.findById( id )
                .orElseThrow( () -> new Exception( "ProductCategory not found" ) );
        model.addAttribute( "category", u );
        return "products/categories/update";
    }
}
