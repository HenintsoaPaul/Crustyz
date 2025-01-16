package mg.crustyz.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.SaleDTO;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.entity.sale.SaleDetail;
import mg.crustyz.repository.sale.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
	private final SaleRepository saleRepository;
	private final SaleDetailService saleDetailService;

	public List<Sale> findAll() {
		return saleRepository.findAll();
	}

	@Transactional
	public void save(SaleDTO saleDTO) throws Exception {
		Sale s = saleRepository.save(saleDTO.getSale());
		double totalPrice = 0;
		for (SaleDetail sd : saleDTO.getSaleDetails()) {
			saleDetailService.save(s, sd);
			totalPrice += sd.getPrice();
		}
		s.setTotalPrice(totalPrice);
		saleRepository.save(s);
	}

	public Sale findById(Integer id) {
		return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
	}

	public List<SaleDetail> findAllDetails(Sale sale) {
		return saleDetailService.findAllBySale(sale);
	}

	private boolean isNature(List<Integer> ids) {
		for (Integer id : ids) {
			if (id == -1)
				return true;
		}
		return false;
	}

	public List<Sale> filterByIngredients(List<Integer> selectedIngredients) {
		if (isNature(selectedIngredients)) {
			return saleRepository.filterBySupplementsNature();
		}

		return saleRepository.filterBySupplements(selectedIngredients);
	}

	public List<Sale> filterByProductCategories(List<Integer> selectedProductCategories) {
		return saleRepository.filterByProductCategories(selectedProductCategories);
	}

	public List<Sale> filter(List<Integer> selectedIngredients, List<Integer> selectedProductCategories) {
		List<Sale> s1 = filterByIngredients(selectedIngredients);
		if (isNature(selectedIngredients)) {
			s1 = saleRepository.filterBySupplementsNature();
		}

		List<Sale> s2 = filterByProductCategories(selectedProductCategories);

		List<Sale> result = new ArrayList<>();
		for (Sale s : s1) {
			boolean found = false;
			for (Sale ss : s2) {
				if (s.getId().equals(ss.getId())) {
					found = true;
					break;
				}
			}
			if (found) {
				result.add(s);
			}
		}

		return result;
	}

	public List<Sale> findAllSalesOn(LocalDate dd) {
		return saleRepository.findAllByDaty(dd);
	}

    public List<Sale> findAllSalesInRange(LocalDate minDate, LocalDate maxDate) {
        return saleRepository.findAllSalesInRange(minDate, maxDate);
    }
}
