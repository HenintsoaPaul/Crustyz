package mg.crustyz.entity.emp;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.sale.Sale;

@Data
@Entity
@Table( name = "comission" )
public class Comission {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_comission", nullable = false )
    private Integer id;

    @Column( name = "taux_comission" )
    private double taux_comission;

    @Column( name = "comission_amount" )
    private double comission_amount;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_sale", nullable = false )
    private Sale sale;

}
