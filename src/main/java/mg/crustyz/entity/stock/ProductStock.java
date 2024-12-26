package mg.crustyz.entity.stock;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Product;



@Data
@Entity
@Table( name = "product_stock" )
public class ProductStock {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_stock_product", nullable = false )
    private Integer id;

    @Column( name = "quantity", nullable = false )
    private double quantity;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

}
