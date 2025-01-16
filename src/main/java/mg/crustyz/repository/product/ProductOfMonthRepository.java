package mg.crustyz.repository.product;

import mg.crustyz.entity.product.ProductOfMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOfMonthRepository extends JpaRepository<ProductOfMonth, Integer> {
	@Query(value = """
			SELECT pom.*
			FROM product_of_month pom
			WHERE EXTRACT(YEAR FROM add_date) = :year AND
			    EXTRACT(MONTH FROM add_date) = :month
			""", nativeQuery = true)
	List<ProductOfMonth> findForMonthYear(int month, int year);

	@Query(value = """
		SELECT pom.*
		FROM product_of_month pom
		WHERE EXTRACT(YEAR FROM add_date) = :year
		""", nativeQuery = true)
List<ProductOfMonth> findForYear(int year);
}
