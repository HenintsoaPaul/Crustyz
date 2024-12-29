package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Rating;
import mg.crustyz.repository.product.ProductRepository;
import mg.crustyz.service.product.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/products/ratings" )
public class RatingController {
    private final RatingService ratingService;
    private final ProductRepository productRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "ratingsList", ratingService.findAll() );
        return "products/ratings/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "productsList", productRepository.findAll() );
        model.addAttribute( "rating", new Rating() );
        return "products/ratings/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "rating" ) Rating rating )
            throws Exception {
        ratingService.save( rating );
        return "redirect:/products/ratings";
    }

//    @GetMapping( "/update/{id}" )
//    public String gotoUpdate( Model model, @PathVariable Integer id )
//            throws Exception {
//        model.addAttribute( "rating", ratingService.findDTOById( id ) );
//        model.addAttribute( "productsList", productService.findAll() );
//        model.addAttribute( "ingredientsList", ingredientService.findAll() );
//        return "products/ratings/update";
//    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id )
            throws Exception {
        model.addAttribute( "productsList", productRepository.findAll() );
        model.addAttribute( "rating", ratingService.findById( id ) );
        return "products/ratings/detail";
    }
}
