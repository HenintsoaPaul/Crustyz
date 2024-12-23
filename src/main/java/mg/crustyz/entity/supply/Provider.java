package mg.crustyz.entity.supply;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "provider" )
public class Provider {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_provider", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
