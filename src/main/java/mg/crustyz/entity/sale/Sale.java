package mg.crustyz.entity.sale;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;


import java.time.LocalDate;

@Data
@Entity
@Table( name = "sale" )
public class Sale {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_sale", nullable = false )
    private Integer id;

    @Column( name = "daty", nullable = false )
    private LocalDate daty;

    @Column( name = "total_price", nullable = false )
    private double totalPrice;

    @ColumnDefault( "'anonymous'" )
    @Column( name = "customer_name", length = 50 )
    private String customerName;

    public String getCustomerName() {
        String name = this.customerName;
        boolean isAnonymous = name == null || name.isBlank();
        return isAnonymous ? "Anonymous" : this.customerName;
    }
}
