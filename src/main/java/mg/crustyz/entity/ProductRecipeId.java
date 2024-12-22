package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Data
@Embeddable
public class ProductRecipeId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 8323234889170141579L;
    @Column( name = "id_product", nullable = false )
    private Integer idProduct;

    @Column( name = "id_recipe", nullable = false )
    private Integer idRecipe;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) return false;
        ProductRecipeId entity = ( ProductRecipeId ) o;
        return Objects.equals( this.idProduct, entity.idProduct ) &&
                Objects.equals( this.idRecipe, entity.idRecipe );
    }

    @Override
    public int hashCode() {
        return Objects.hash( idProduct, idRecipe );
    }

}
