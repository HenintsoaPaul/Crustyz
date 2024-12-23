package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table( name = "supply" )
public class Supply {
    @Id
    @ColumnDefault( "nextval('supply_id_supply_seq')" )
    @Column( name = "id_supply", nullable = false )
    private Integer id;

    @Column( name = "daty", length = 50 )
    private String daty;

    @Column( name = "total_price", nullable = false, precision = 15, scale = 2 )
    private BigDecimal totalPrice;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_provider", nullable = false )
    private Provider idProvider;

}
