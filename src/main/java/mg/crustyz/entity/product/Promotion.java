package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table( name = "promotion" )
public class Promotion {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_promotion", nullable = false )
    private Integer id;

    @Column( name = "beginning_daty", nullable = false )
    private LocalDate beginningDaty;

    @Column( name = "ending_daty", nullable = false )
    private LocalDate endingDaty;

}
