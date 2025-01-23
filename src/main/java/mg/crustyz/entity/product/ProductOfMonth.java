package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Data
@Entity
@Table( name = "product_of_month" )
public class ProductOfMonth {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_product_of_month", nullable = false )
    private Integer id;

    @Column( name = "add_date", nullable = false )
    private LocalDate addDate;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

    public String getMonthYear() {
        String nomMois = this.addDate.getMonth().getDisplayName(
                TextStyle.FULL,
                Locale.FRENCH
        );

        nomMois = nomMois.substring(0, 1).toUpperCase() + nomMois.substring(1);

        return nomMois + " " + this.addDate.getYear();
    }
}
