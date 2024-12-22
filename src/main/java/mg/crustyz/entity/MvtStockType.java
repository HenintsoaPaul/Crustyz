package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table( name = "mvt_stock_type" )
public class MvtStockType {
    @Id
    @ColumnDefault( "nextval('mvt_stock_type_id_mvt_stock_type_seq')" )
    @Column( name = "id_mvt_stock_type", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
