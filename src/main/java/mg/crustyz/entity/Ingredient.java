package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table( name = "ingredient" )
public class Ingredient {
    @Id
    @ColumnDefault( "nextval('ingredient_id_ingredient_seq')" )
    @Column( name = "id_ingredient", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_unit", nullable = false )
    private mg.crustyz.entity.Unit idUnit;

}
