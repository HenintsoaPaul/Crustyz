package mg.crustyz.entity.recipe;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Ingredient;



@Data
@Entity
@Table( name = "recipe_step" )
public class RecipeStep {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_recipe_step", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    @Column( name = "no_step" )
    private Integer noStep;

    @Column( name = "description", length = Integer.MAX_VALUE )
    private String description;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_recipe", nullable = false )
    private Recipe recipe;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_recipe_step_type", nullable = false )
    private RecipeStepType recipe_step_type;

}
