package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.product.Promotion;
import mg.crustyz.entity.product.ProductPromotion;

import java.util.ArrayList;
import java.util.List;


@Data
public class PromotionDTO {
    private Promotion promotion;
    private List<ProductPromotion> productPromotions = new ArrayList<>();

    public PromotionDTO() {
        this.productPromotions.add( new ProductPromotion() );
    }
}
