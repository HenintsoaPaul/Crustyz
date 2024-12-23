package mg.crustyz.entity.recipe;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "recipe" )
public class Recipe {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_recipe", nullable = false )
    private Integer id;

    @Column( name = "name", length = 50 )
    private String name;

    @Column( name = "description", length = Integer.MAX_VALUE )
    private String description;

}
