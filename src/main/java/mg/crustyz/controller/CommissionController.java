package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.CommissionDTO;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.service.SaleService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/commissions")
public class CommissionController {
    private final SaleService saleService;

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

        List<CommissionDTO> dtos = new ArrayList<>();
        for (Sale s : sales) {
            dtos.add(new CommissionDTO(s));
        }

        System.out.println(dtos);

        model.addAttribute("commissionsList", dtos);
        return "commissions/index";
    }
}
