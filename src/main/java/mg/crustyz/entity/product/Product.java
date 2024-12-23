package mg.crustyz.entity.product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "product" )
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_product", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    @Column( name = "description", length = Integer.MAX_VALUE )
    private String description;

    @Column( name = "unit_price", nullable = false, precision = 15, scale = 2 )
    private BigDecimal unitPrice;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_unit", nullable = false )
    private mg.crustyz.entity.Unit idUnit;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product_category", nullable = false )
    private ProductCategory idProductCategory;

}
