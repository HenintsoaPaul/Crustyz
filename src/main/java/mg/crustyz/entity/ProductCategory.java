package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table( name = "product_category" )
public class ProductCategory {
    @Id
    @ColumnDefault( "nextval('product_category_id_product_category_seq')" )
    @Column( name = "id_product_category", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
