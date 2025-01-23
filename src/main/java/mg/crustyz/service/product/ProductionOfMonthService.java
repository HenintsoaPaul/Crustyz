package mg.crustyz.service.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Product;
import mg.crustyz.entity.product.Production;
import mg.crustyz.repository.product.ProductOfMonthRepository;
import mg.crustyz.repository.product.ProductRepository;
import mg.crustyz.repository.product.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionOfMonthService {
    private final ProductOfMonthRepository productOfMonthRepository;

    List<String> findAllMonth() {
        List<String> l = new ArrayList<>();
        l.add("Janvier");
        l.add("Fevrier");
        l.add("Mars");
        l.add("Avril");
        l.add("Mai");
        l.add("Juin");
        l.add("Juillet");
        l.add("Aout");
        l.add("Septembre");
        l.add("Octobre");
        l.add("Novembre");
        l.add("Decembre");
        return l;
    }
}
