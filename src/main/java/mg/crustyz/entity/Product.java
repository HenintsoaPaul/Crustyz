package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "product" )
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "product_id_gen" )
    @SequenceGenerator( name = "product_id_gen", sequenceName = "product_id_product_seq", allocationSize = 1 )
    @Column( name = "id_product", nullable = false )
    private Integer id;

    @Column( name = "name", length = 50 )
    private String name;

    @Column( name = "description", length = Integer.MAX_VALUE )
    private String description;

    @Column( name = "unit_price", nullable = false, precision = 15, scale = 2 )
    private BigDecimal unitPrice;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_baking", nullable = false )
    private Baking idBaking;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product_type", nullable = false )
    private mg.crustyz.entity.ProductType idProductType;

}
