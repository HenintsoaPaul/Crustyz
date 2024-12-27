package mg.crustyz.entity.sale;

import jakarta.persistence.*;
import lombok.Data;
import mg.crustyz.entity.product.Product;



@Data
@Entity
@Table( name = "sale_detail" )
public class SaleDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_sale_detail", nullable = false )
    private Integer id;

    @Column( name = "quantity" )
    private double quantity;

    @Column( name = "price" )
    private double price;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product product;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_sale", nullable = false )
    private Sale sale;

}
