package mg.crustyz.repository.stock;

import mg.crustyz.entity.stock.MvtProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MvtProductStockRepository extends JpaRepository<MvtProductStock, Integer> {
    @Query( "SELECT mvt " +
            "FROM MvtProductStock mvt " +
            "WHERE mvt.product.id = :id" )
    List<MvtProductStock> getByIdProduct( @Param( "id" ) int id );
}
