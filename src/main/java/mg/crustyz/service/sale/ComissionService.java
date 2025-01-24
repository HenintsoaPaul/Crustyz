package mg.crustyz.service.sale;

import lombok.AllArgsConstructor;
import mg.crustyz.entity.emp.Comission;
import mg.crustyz.repository.ComissionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComissionService {
    private final ComissionRepository comissionRepository;

    public List<Comission> findAll() {
        return comissionRepository.findAll();
    }

    public List<Double> getComissions(List<Comission> comissionList) {
        List<Double> comissions = new ArrayList<>();

        double total = 0;
        for (Comission c : findAllComissionsBandy()) {
            if (comissionList.contains(c)) {
                total += c.getComission_amount();
            }
        }
        comissions.add(total);

        total = 0;
        for (Comission c : findAllComissionsSipa()) {
            if (comissionList.contains(c)) {
                total += c.getComission_amount();
            }
        }
        comissions.add(total);

        return comissions;
    }


    public List<Comission> findAllComissionsBandy() {
        return comissionRepository.findAllComissionsByEmployeeSexe(1);
    }

    public List<Comission> findAllComissionsSipa() {
        return comissionRepository.findAllComissionsByEmployeeSexe(2);
    }

    public List<Comission> findAllComissionsAfterDateMin(LocalDate minDate) {
        return comissionRepository.findAllComissionsAfterDateMin(minDate);
    }

    public List<Comission> findAllComissionsBeforeDateMax(LocalDate maxDate) {
        return comissionRepository.findAllComissionsBeforeDateMax(maxDate);
    }
}
