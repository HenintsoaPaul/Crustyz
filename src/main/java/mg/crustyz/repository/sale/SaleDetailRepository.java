package mg.crustyz.repository.sale;

import mg.crustyz.entity.sale.Sale;
import mg.crustyz.entity.sale.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Integer> {
    @Query("SELECT sd " +
            "FROM SaleDetail sd " +
            "WHERE sd.sale = :sale")
    List<SaleDetail> findAllBySale( @Param( "sale" ) Sale sale );
}
