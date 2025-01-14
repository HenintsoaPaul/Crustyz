package mg.crustyz.entity.recipe;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "recipe_step_type" )
public class RecipeStepType {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_recipe_step_type", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
