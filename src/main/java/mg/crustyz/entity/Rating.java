package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table( name = "rating" )
public class Rating {
    @Id
    @ColumnDefault( "nextval('rating_id_rating_seq')" )
    @Column( name = "id_rating", nullable = false )
    private Integer id;

    @Column( name = "nb_star", nullable = false )
    private Integer nbStar;

    @ColumnDefault( "'anonymous'" )
    @Column( name = "author", nullable = false, length = 50 )
    private String author;

    @Column( name = "daty", nullable = false )
    private LocalDate daty;

    @Column( name = "comment", length = Integer.MAX_VALUE )
    private String comment;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_product", nullable = false )
    private Product idProduct;

}
