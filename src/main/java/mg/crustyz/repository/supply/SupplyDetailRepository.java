package mg.crustyz.repository.supply;

import mg.crustyz.entity.supply.Supply;
import mg.crustyz.entity.supply.SupplyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplyDetailRepository extends JpaRepository<SupplyDetail, Integer> {
    @Query("SELECT sd " +
            "FROM SupplyDetail sd " +
            "WHERE sd.supply = :supply")
    List<SupplyDetail> findAllBySupply( @Param( "supply" ) Supply supply );
}
