package mg.crustyz.entity.recipe;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.emp.Employee;
import mg.crustyz.entity.product.Ingredient;

import java.math.BigDecimal;

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

    @Column( name = "quantity_used", precision = 15, scale = 2 )
    private BigDecimal quantityUsed;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_baker", nullable = false )
    private Employee idBaker;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private Ingredient idIngredient;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_recipe", nullable = false )
    private Recipe idRecipe;

}
