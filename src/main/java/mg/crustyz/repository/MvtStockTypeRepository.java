package mg.crustyz.repository;

import mg.crustyz.entity.stock.MvtStockType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStockTypeRepository extends JpaRepository<MvtStockType, Integer> {
}
