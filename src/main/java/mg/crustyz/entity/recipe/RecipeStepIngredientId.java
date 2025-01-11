package mg.crustyz.entity.recipe;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Data
@Embeddable
public class RecipeStepIngredientId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 153876042378677256L;
    @Column( name = "id_ingredient", nullable = false )
    private Integer idIngredient;

    @Column( name = "id_recipe_step", nullable = false )
    private Integer idRecipeStep;

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) ) return false;
        RecipeStepIngredientId entity = (RecipeStepIngredientId) o;
        return Objects.equals( this.idIngredient, entity.idIngredient ) &&
                Objects.equals( this.idRecipeStep, entity.idRecipeStep );
    }

    @Override
    public int hashCode() {
        return Objects.hash( idIngredient, idRecipeStep );
    }

}
