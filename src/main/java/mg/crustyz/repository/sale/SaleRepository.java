package mg.crustyz.repository.sale;

import mg.crustyz.entity.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
