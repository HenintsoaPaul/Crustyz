package mg.crustyz.controller.sale;

import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.SaleDTO;
import mg.crustyz.entity.product.Ingredient;
import mg.crustyz.entity.product.ProductCategory;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.repository.IngredientRepository;
import mg.crustyz.repository.product.ProductCategoryRepository;
import mg.crustyz.service.ProductStockService;
import mg.crustyz.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SaleController {
	private final SaleService saleService;
	private final ProductStockService productStockService;
	private final ProductCategoryRepository productCategoryRepository;
	private final IngredientRepository ingredientRepository;

	@GetMapping
	public String getAll(Model model,
			@RequestParam(required = false) List<Integer> selectedProductCategories,
			@RequestParam(required = false) List<Integer> selectedIngredients,
			@RequestParam(required = false) String dateAchat) {

		List<Sale> sales = saleService.findAll();
		List<ProductCategory> productCategories = productCategoryRepository.findAll();
		List<Ingredient> ingredients = ingredientRepository.findAll();

		boolean misyIngredients;
		boolean misyProductCategories;
		boolean misyRoa;

		misyIngredients = selectedIngredients != null && !selectedIngredients.isEmpty();
		misyProductCategories = selectedProductCategories != null && !selectedProductCategories.isEmpty();
		misyRoa = misyIngredients && misyProductCategories;

		if (misyRoa) {
			sales = saleService.filter(selectedIngredients, selectedProductCategories);
		} else {
			if (misyIngredients) {
				sales = saleService.filterByIngredients(selectedIngredients);
			}
			if (misyProductCategories) {
				sales = saleService.filterByProductCategories(selectedProductCategories);
			}
		}

		// todo: tsy misy override otrazao
		if (dateAchat!= null && !dateAchat.isEmpty()) {
			LocalDate dd = LocalDate.parse(dateAchat, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.print(dateAchat);
			List<Sale> salesOnDaty = saleService.findAllSalesOn( dd );

			// On recherche les objets a la fois dans sales et salesOnDaty
			sales.retainAll(salesOnDaty);
			// for(Sale ss : salesOnDaty) {
			// }
		}

		model.addAttribute("salesList", sales);
		model.addAttribute("productCategoriesList", productCategories);
		model.addAttribute("ingredientsList", ingredients);

		return "sales/index";
	}

	@GetMapping("/add")
	public String gotoSave(Model model) {
		model.addAttribute("productStocksList", productStockService.findAll());
		model.addAttribute("saleDTO", new SaleDTO());
		return "sales/add";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("saleDTO") SaleDTO saleDTO) throws Exception {
		saleService.save(saleDTO);
		return "redirect:/sales";
	}

	@GetMapping("/{id}")
	public String detail(Model model, @PathVariable Integer id) {
		Sale sale = saleService.findById(id);
		model.addAttribute("sale", sale);
		model.addAttribute("saleDetailsList", saleService.findAllDetails(sale));
		return "sales/detail";
	}
}
