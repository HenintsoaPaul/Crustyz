package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.PromotionDTO;
import mg.crustyz.entity.product.Promotion;
import mg.crustyz.repository.product.ProductRepository;
import mg.crustyz.service.product.ProductPromotionService;
import mg.crustyz.service.product.PromotionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/promotions" )
public class PromotionController {
    private final PromotionService promotionService;
    private final ProductPromotionService productPromotionService;
    private final ProductRepository productRepository;

    @GetMapping
    public String getAll( Model model ) {
        model.addAttribute( "promotionsList", promotionService.findAll() );
        return "promotions/index";
    }

    @GetMapping( "/add" )
    public String gotoSave( Model model ) {
        model.addAttribute( "productsList", productRepository.findAll() );
        model.addAttribute( "promotionDTO", new PromotionDTO() );
        return "promotions/add";
    }

    @PostMapping( "/save" )
    public String save( @ModelAttribute( "promotionDTO" ) PromotionDTO promotionDTO )
            throws Exception {
        promotionService.save( promotionDTO );
        return "redirect:/promotions";
    }

//    @GetMapping( "/update/{id}" )
//    public String gotoUpdate( Model model, @PathVariable Integer id )
//            throws Exception {
//        model.addAttribute( "promotionDTO", promotionService.findDTOById( id ) );
//        model.addAttribute( "productsList", productRepository.findAll() );
//        model.addAttribute( "ingredientsList", ingredientRepository.findAll() );
//        return "promotions/update";
//    }

    @GetMapping( "/{id}" )
    public String detail( Model model, @PathVariable Integer id )
            throws Exception {
        Promotion promotion = promotionService.findById( id );
        model.addAttribute( "promotion", promotion );
        model.addAttribute( "productPromotions", productPromotionService.findAllByPromotion( promotion ) );
        return "promotions/detail";
    }
}
