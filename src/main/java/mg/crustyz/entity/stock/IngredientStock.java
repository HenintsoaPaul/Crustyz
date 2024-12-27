package mg.crustyz.entity.stock;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Ingredient;



@Data
@Entity
@Table( name = "ingredient_stock" )
public class IngredientStock {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_ingredient_stock", nullable = false )
    private Integer id;

    @Column( name = "quantity", nullable = false )
    private double quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient", nullable = false )
    private Ingredient ingredient;

}
