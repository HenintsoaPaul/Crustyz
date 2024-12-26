package mg.crustyz.repository.stock;

import mg.crustyz.entity.stock.MvtIngredientStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MvtIngredientStockRepository extends JpaRepository<MvtIngredientStock, Integer> {
    @Query( "SELECT mvt " +
            "FROM MvtIngredientStock mvt " +
            "WHERE mvt.ingredient.id = :id" )
    List<MvtIngredientStock> getByIdIngredient( @Param( "id" ) int id );
}
