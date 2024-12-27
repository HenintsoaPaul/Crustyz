package mg.crustyz.repository.supply;

import mg.crustyz.entity.supply.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply, Integer> {
}
