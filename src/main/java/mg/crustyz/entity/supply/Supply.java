package mg.crustyz.entity.supply;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "supply" )
public class Supply {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
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
