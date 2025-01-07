package mg.crustyz.repository.product;

import mg.crustyz.entity.product.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductionRepository extends JpaRepository<Production, Integer> {

    @Query(value = """
            SELECT DISTINCT p.*
            FROM production p
                     JOIN recipe_product rp ON p.id_product = rp.id_product
                     JOIN recipe_step rs ON rp.id_recipe = rs.id_recipe
                     JOIN ingredient i ON rs.id_ingredient = i.id_ingredient
            WHERE i.id_ingredient IN (:ingredientIds)
            """, nativeQuery = true)
    List<Production> findByIngredientsIn( List<Integer> ingredientIds );
}
