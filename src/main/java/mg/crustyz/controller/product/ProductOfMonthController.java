package mg.crustyz.controller.product;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.ProductOfMonth;
import mg.crustyz.repository.product.ProductOfMonthRepository;
import mg.crustyz.repository.product.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products/month")
public class ProductOfMonthController {
    private final ProductOfMonthRepository productCategoryRepository;
    private final ProductRepository productRepository;

    @GetMapping
    public String getAll(Model model, @RequestParam(required = false) String monthYear) {
	List<ProductOfMonth> pom = productCategoryRepository.findAll();

	if (monthYear != null) {
	    System.out.println("monthYear = " + monthYear);
	    LocalDate localDate = LocalDate.parse(monthYear, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	    pom = productCategoryRepository.findForMonth(localDate.getMonthValue(), localDate.getYear());
	}

	// todo: atao distinct par categorie ilay izy satri possible misy miverina
	// ...

	model.addAttribute("productOfMonthsList", pom);
	return "products/month/index";
    }

    @GetMapping("/add")
    public String gotoSave(Model model) {
	model.addAttribute("productsList", productRepository.findAll());
	model.addAttribute("productOfMonth", new ProductOfMonth());
	return "products/month/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("productOfMonth") ProductOfMonth productOfMonth) {
	productCategoryRepository.save(productOfMonth);
	return "redirect:/products/month";
    }

    @GetMapping("/update/{id}")
    public String formNew(Model model, @PathVariable Integer id) throws Exception {
	ProductOfMonth u = productCategoryRepository.findById(id)
		.orElseThrow(() -> new Exception("ProductOfMonth not found"));
	model.addAttribute("productOfMonth", u);
	model.addAttribute("productsList", productRepository.findAll());
	return "products/month/update";
    }
}
