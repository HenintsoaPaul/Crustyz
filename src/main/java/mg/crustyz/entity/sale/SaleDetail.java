package mg.crustyz.entity.sale;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Product;

import java.math.BigDecimal;

@Data
@Entity
@Table( name = "sale_detail" )
public class SaleDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_sale_detail", nullable = false )
    private Integer id;

    @Column( name = "quantity", precision = 15, scale = 2 )
    private BigDecimal quantity;

    @Column( name = "price", precision = 15, scale = 2 )
    private BigDecimal price;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_sale", nullable = false )
    private Sale idSale;

}
