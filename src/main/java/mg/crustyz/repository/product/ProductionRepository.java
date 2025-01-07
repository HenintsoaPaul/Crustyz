package mg.crustyz.repository.product;

import mg.crustyz.entity.product.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Integer> {
}
