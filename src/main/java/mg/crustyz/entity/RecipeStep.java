package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "recipe_step" )
public class RecipeStep {
    @Id
    @ColumnDefault( "nextval('recipe_step_id_recipe_step_seq')" )
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
