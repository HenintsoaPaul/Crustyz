package mg.crustyz.entity.supply;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table( name = "supply" )
public class Supply {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_supply", nullable = false )
    private Integer id;

    @Column( name = "daty", length = 50 )
    private LocalDate daty;

    @Column( name = "total_price", nullable = false )
    private double totalPrice;

}
