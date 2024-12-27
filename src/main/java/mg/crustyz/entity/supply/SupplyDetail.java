package mg.crustyz.entity.supply;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table( name = "supply_detail" )
public class SupplyDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_supply_detail", nullable = false )
    private Integer id;

    @Column( name = "quantity" )
    private double quantity;

    @Column( name = "price" )
    private double price;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient_provider", nullable = false )
    private IngredientProvider ingredientProvider;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_supply", nullable = false )
    private Supply supply;

}
