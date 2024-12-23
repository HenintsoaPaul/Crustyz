package mg.crustyz.entity.stock;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Product;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "product_stock" )
public class ProductStock {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_stock_product", nullable = false )
    private Integer id;

    @Column( name = "quantity", nullable = false, precision = 15, scale = 2 )
    private BigDecimal quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

}
