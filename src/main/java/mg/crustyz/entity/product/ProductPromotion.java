package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "product_promotion" )
public class ProductPromotion {
    @EmbeddedId
    private ProductPromotionId id;

    @MapsId( "idProduct" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

    @MapsId( "idPromotion" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_promotion", nullable = false )
    private Promotion promotion;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @Column( name = "percent_off", precision = 2, scale = 2 )
    private BigDecimal percentOff;

}
