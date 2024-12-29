package mg.crustyz.service.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Rating;
import mg.crustyz.repository.product.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Rating findById( Integer id )
            throws Exception {
        return ratingRepository.findById( id )
                .orElseThrow( () -> new Exception( "Rating not found" ) );
    }

    @Transactional
    public void save( Rating rating ) {
        ratingRepository.save( rating );
    }

}
