package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "baker" )
public class Baker {
    @SequenceGenerator( name = "baker_id_gen", sequenceName = "product_id_product_seq", allocationSize = 1 )
    @EmbeddedId
    private BakerId id;

    @MapsId( "idBaking" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_baking", nullable = false )
    private mg.crustyz.entity.Baking idBaking;

    @MapsId( "idEmployee" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_employee", nullable = false )
    private mg.crustyz.entity.Employee idEmployee;

}
