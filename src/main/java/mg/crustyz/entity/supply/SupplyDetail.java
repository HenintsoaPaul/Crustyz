package mg.crustyz.entity.supply;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "supply_detail" )
public class SupplyDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_supply_detail", nullable = false )
    private Integer id;

    @Column( name = "quantity", precision = 15, scale = 2 )
    private BigDecimal quantity;

    @Column( name = "price", precision = 15, scale = 2 )
    private BigDecimal price;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_ingredient_provider", nullable = false )
    private IngredientProvider idIngredientProvider;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_supply", nullable = false )
    private Supply idSupply;

}
