package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "product_category" )
public class ProductCategory {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_product_category", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
