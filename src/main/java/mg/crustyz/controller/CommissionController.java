package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.CrustyzProperties;
import mg.crustyz.dto.CommissionDTO;
import mg.crustyz.entity.emp.Employee;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.service.SaleService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/commissions")
public class CommissionController {
    private final SaleService saleService;
    private final CrustyzProperties crustyzProperties;

    @GetMapping
    public String getAll(Model model,
            @RequestParam(required = false) String dateMin,
            @RequestParam(required = false) String dateMax) {

        List<Sale> sales = saleService.findAll();

        // dateMin
        if (dateMin != null && !dateMin.isEmpty()) {
            LocalDate dd = LocalDate.parse(dateMin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            List<Sale> salesOnDaty = saleService.findAllSalesAfterDateMin(dd);
            sales.retainAll(salesOnDaty);
        }

        // dateMax
        if (dateMax != null && !dateMax.isEmpty()) {
            LocalDate dd = LocalDate.parse(dateMax, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            List<Sale> salesOnDaty = saleService.findAllSalesBeforeDateMax(dd);
            sales.retainAll(salesOnDaty);
        }

        // Group sales by employee and total price
        Map<Employee, Double> salesByEmployee = sales.stream()
            .collect(Collectors.groupingBy(
                Sale::getEmployee,
                Collectors.summingDouble(Sale::getTotalPrice)
            ));

        // Convert the map to a list of CommissionDTO
        List<CommissionDTO> dtos = salesByEmployee.entrySet().stream()
            .map(entry -> new CommissionDTO(entry.getKey(), entry.getValue(), crustyzProperties.getTauxCommission()))
            .collect(Collectors.toList());

        System.out.println(dtos);

        model.addAttribute("commissionsList", dtos);
        return "commissions/index";
    }
}
