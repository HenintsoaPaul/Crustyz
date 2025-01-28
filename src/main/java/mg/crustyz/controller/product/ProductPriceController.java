package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.ProductPrice;
import mg.crustyz.service.product.ProductPriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products/prices")
public class ProductPriceController {
    private final ProductPriceService productPriceService;

    @GetMapping
    public String getAll(Model model, @RequestParam(required = false) Integer idProduct) {
        List<ProductPrice> productPrices = productPriceService.findAll();


        if (idProduct != null) {
            System.out.println("idProduct: " + idProduct);
            productPrices.removeIf(productPrice -> !productPrice.getProduct().getId().equals(idProduct));
        }

        model.addAttribute("productList", productPriceService.findAllProduct());
        model.addAttribute("productPrices", productPrices);

        return "products/prices/index";
    }

    @GetMapping("/add")
    public String gotoSave(Model model) {
        model.addAttribute("productPrice", new ProductPrice());
        model.addAttribute("productList", productPriceService.findAllProduct());
        return "products/prices/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("productPrice") ProductPrice productPrice) throws Exception {
        productPriceService.save(productPrice);
        return "redirect:/products/prices";
    }

    @GetMapping("/update/{id}")
    public String formNew(Model model, @PathVariable Integer id)
            throws Exception {
        model.addAttribute("productPrice", productPriceService.findById(id));
        model.addAttribute("productList", productPriceService.findAllProduct());

        return "products/prices/update";
    }
}
