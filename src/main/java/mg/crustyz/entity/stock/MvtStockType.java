package mg.crustyz.entity.stock;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "mvt_stock_type" )
public class MvtStockType {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_mvt_stock_type", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    public String getIcon() {
        if (id == 1) {
            return "bi bi-caret-down";
        }
        return "bi bi-caret-up";
    }
}
