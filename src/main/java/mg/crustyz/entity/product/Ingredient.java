package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "ingredient" )
public class Ingredient {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_ingredient", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_unit", nullable = false )
    private mg.crustyz.entity.Unit unit;

}
