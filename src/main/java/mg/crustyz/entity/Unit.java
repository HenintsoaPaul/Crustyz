package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table( name = "unit", uniqueConstraints = {
        @UniqueConstraint( name = "unit_name_key", columnNames = { "name" } )
} )
public class Unit {
    @Id
    @ColumnDefault( "nextval('unit_id_unit_seq')" )
    @Column( name = "id_unit", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
