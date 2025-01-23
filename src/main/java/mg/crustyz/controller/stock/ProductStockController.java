package mg.crustyz.controller.stock;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.stock.ProductStock;
import mg.crustyz.service.ProductStockService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stocks/products")
public class ProductStockController {
    private final ProductStockService productStockService;

    @GetMapping
    public String get(Model model,
            @RequestParam(required = false) String nomProduit) {
        List<ProductStock> productStocks = productStockService.findAll();

        if (nomProduit != null && !nomProduit.isEmpty()) {
            List<ProductStock> byName = productStockService.findByProductNameContaining(nomProduit);

            productStocks.retainAll(byName);
        }

        model.addAttribute("productStocksList", productStocks);
        return "stocks/products/index";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable Integer id)
            throws Exception {
        ProductStock productStock = productStockService.findById(id);
        int idProduct = productStock.getProduct().getId();

        model.addAttribute("stock", productStock);
        model.addAttribute("mvtList", productStockService.findAllMvtByIdProduct(idProduct));
        return "stocks/products/mvt";
    }
}
