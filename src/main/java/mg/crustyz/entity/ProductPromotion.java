package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "product_promotion" )
public class ProductPromotion {
    @EmbeddedId
    private ProductPromotionId id;

    @MapsId( "idProduct" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

    @MapsId( "idPromotion" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_promotion", nullable = false )
    private mg.crustyz.entity.Promotion idPromotion;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @Column( name = "percent_off", precision = 2, scale = 2 )
    private BigDecimal percentOff;

}
