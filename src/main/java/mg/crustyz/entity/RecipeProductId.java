package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RecipeProductId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1538760423786772526L;
    @Column( name = "id_product", nullable = false )
    private Integer idProduct;

    @Column( name = "id_recipe", nullable = false )
    private Integer idRecipe;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) return false;
        RecipeProductId entity = ( RecipeProductId ) o;
        return Objects.equals( this.idProduct, entity.idProduct ) &&
                Objects.equals( this.idRecipe, entity.idRecipe );
    }

    @Override
    public int hashCode() {
        return Objects.hash( idProduct, idRecipe );
    }

}
