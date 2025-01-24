package mg.crustyz.controller;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.emp.Comission;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import mg.crustyz.service.sale.ComissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/commissions")
public class CommissionController {
    private final ComissionService comissionService;

    @GetMapping
    public String getAll(Model model,
                         @RequestParam(required = false) String dateMin,
                         @RequestParam(required = false) String dateMax) {
        List<Comission> comissions = comissionService.findAll();

        // dateMin
        if (dateMin != null && !dateMin.isEmpty()) {
            LocalDate dd = LocalDate.parse(dateMin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            comissions.retainAll(comissionService.findAllComissionsAfterDateMin(dd));
        }

        // dateMax
        if (dateMax != null && !dateMax.isEmpty()) {
            LocalDate dd = LocalDate.parse(dateMax, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            comissions.retainAll(comissionService.findAllComissionsBeforeDateMax(dd));
        }

        model.addAttribute("commissions", comissions);
        model.addAttribute("generalComissions", comissionService.getComissions(comissions));
        return "commissions/index";
    }
}
