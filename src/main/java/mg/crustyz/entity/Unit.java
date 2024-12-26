package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "unit", uniqueConstraints = {
        @UniqueConstraint( name = "unit_name_key", columnNames = { "name" } )
} )
public class Unit {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_unit", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    @Column( name = "symbol", nullable = false, length = 50 )
    private String symbol;

}
