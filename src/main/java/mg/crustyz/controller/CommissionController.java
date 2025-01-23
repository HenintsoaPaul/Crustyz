package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.CrustyzProperties;
import mg.crustyz.entity.emp.Comission;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.repository.ComissionRepository;
import mg.crustyz.service.SaleService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/commissions")
public class CommissionController {
    private final SaleService saleService;
    private final CrustyzProperties crustyzProperties;
    private final ComissionRepository comissionRepository;

    @GetMapping
    public String getAll(Model model,
                         @RequestParam(required = false) String checkboxFemme,
                         @RequestParam(required = false) String checkboxHomme,
                         @RequestParam(required = false) String dateMin,
                         @RequestParam(required = false) String dateMax) {

        List<Sale> sales = saleService.findAll();
        List<Comission> comissions = comissionRepository.findAll();

        // dateMin
        if (dateMin != null && !dateMin.isEmpty()) {
            LocalDate dd = LocalDate.parse(dateMin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            List<Sale> salesOnDaty = saleService.findAllSalesAfterDateMin(dd);
            sales.retainAll(salesOnDaty);

            comissions.retainAll(saleService.findAllComissionsAfterDateMin(dd));
        }

        // dateMax
        if (dateMax != null && !dateMax.isEmpty()) {
            LocalDate dd = LocalDate.parse(dateMax, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            List<Sale> salesOnDaty = saleService.findAllSalesBeforeDateMax(dd);
            sales.retainAll(salesOnDaty);

            comissions.retainAll(saleService.findAllComissionsBeforeDateMax(dd));
        }

        model.addAttribute("commissions", comissions);
        model.addAttribute("generalComissions", saleService.getComissions(comissions));
        return "commissions/index";
    }
}
