package mg.crustyz.repository.sale;

import mg.crustyz.entity.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

	@Query(value = """
			SELECT DISTINCT s.*
			FROM sale s
					 JOIN sale_detail sd ON sd.id_sale = s.id_sale
					 JOIN recipe_product rp ON rp.id_product = sd.id_product
					 JOIN (SELECT * FROM recipe_step WHERE id_recipe_step_type = 2) rs ON rp.id_recipe = rs.id_recipe
					 JOIN recipe_step_ingredient rsi ON rs.id_recipe_step = rsi.id_recipe_step
					 JOIN ingredient i ON rsi.id_ingredient = i.id_ingredient
			WHERE i.id_ingredient IN (:ingredientIds)
			""", nativeQuery = true)
	List<Sale> filterBySupplements(List<Integer> ingredientIds);

	@Query(value = """
			SELECT DISTINCT s.*
			FROM sale s
					 JOIN sale_detail sd ON sd.id_sale = s.id_sale
					 JOIN product prod ON prod.id_product = sd.id_product
					 JOIN product_category pc ON prod.id_product_category = pc.id_product_category
			WHERE pc.id_product_category IN (:productCategoriesId)
			""", nativeQuery = true)
	List<Sale> filterByProductCategories(List<Integer> productCategoriesId);

	@Query(value = """
			select distinct  sa.* from sale sa
										  where sa.id_sale NOT in (SELECT DISTINCT s.id_sale
			FROM sale s
					 JOIN sale_detail sd ON sd.id_sale = s.id_sale
					 JOIN recipe_product rp ON rp.id_product = sd.id_product
					 JOIN recipe_step rs ON rp.id_recipe = rs.id_recipe
					WHERE rs.id_recipe_step_type = 2)
			""", nativeQuery = true)
	List<Sale> filterBySupplementsNature();

	List<Sale> findAllByDaty(LocalDate dd);

	@Query(value = """
			select * from sale s where s.daty >= :dateMin
			""", nativeQuery = true)
	List<Sale> findAllSalesAfterDateMin(LocalDate dateMin);

	@Query(value = """
			select * from sale s where s.daty <= :dateMax
			""", nativeQuery = true)
	List<Sale> findAllSalesBeforeDateMax(LocalDate dateMax);

	@Query(value = """
			select * from sale s where s.total_price >= :prixMin
			""", nativeQuery = true)
	List<Sale> findAllSalesSupTo(int prixMin);

	@Query(value = """
			select * from sale s where s.total_price <= :prixMax
			""", nativeQuery = true)
	List<Sale> findAllSalesInfTo(int prixMax);
}
