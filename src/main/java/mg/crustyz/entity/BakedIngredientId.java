package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Data
@Embeddable
public class BakedIngredientId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 7569901051959968511L;
    @Column( name = "id_ingredient", nullable = false )
    private Integer idIngredient;

    @Column( name = "id_baking", nullable = false )
    private Integer idBaking;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) return false;
        BakedIngredientId entity = ( BakedIngredientId ) o;
        return Objects.equals( this.idBaking, entity.idBaking ) &&
                Objects.equals( this.idIngredient, entity.idIngredient );
    }

    @Override
    public int hashCode() {
        return Objects.hash( idBaking, idIngredient );
    }

}
