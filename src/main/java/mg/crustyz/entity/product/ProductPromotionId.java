package mg.crustyz.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Data
@Embeddable
public class ProductPromotionId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 8329928825745359153L;
    @Column( name = "id_product", nullable = false )
    private Integer idProduct;

    @Column( name = "id_promotion", nullable = false )
    private Integer idPromotion;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) return false;
        ProductPromotionId entity = ( ProductPromotionId ) o;
        return Objects.equals( this.idPromotion, entity.idPromotion ) &&
                Objects.equals( this.idProduct, entity.idProduct );
    }

    @Override
    public int hashCode() {
        return Objects.hash( idPromotion, idProduct );
    }

}
