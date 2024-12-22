package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "product_recipe" )
public class ProductRecipe {
    @EmbeddedId
    private ProductRecipeId id;

    @MapsId( "idProduct" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

    @MapsId( "idRecipe" )
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_recipe", nullable = false )
    private mg.crustyz.entity.Recipe idRecipe;

}
