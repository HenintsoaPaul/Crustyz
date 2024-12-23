package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "supply_detail" )
public class SupplyDetail {
    @Id
    @ColumnDefault( "nextval('supply_detail_id_supply_detail_seq')" )
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
