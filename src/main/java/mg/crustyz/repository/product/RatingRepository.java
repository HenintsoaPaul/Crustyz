package mg.crustyz.repository.product;

import mg.crustyz.entity.product.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
