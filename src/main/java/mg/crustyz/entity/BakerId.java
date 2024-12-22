package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Data
@Embeddable
public class BakerId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = -7408970116449819574L;
    @Column( name = "id_baking", nullable = false )
    private Integer idBaking;

    @Column( name = "id_employee", nullable = false )
    private Integer idEmployee;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) return false;
        BakerId entity = ( BakerId ) o;
        return Objects.equals( this.idEmployee, entity.idEmployee ) &&
                Objects.equals( this.idBaking, entity.idBaking );
    }

    @Override
    public int hashCode() {
        return Objects.hash( idEmployee, idBaking );
    }

}
