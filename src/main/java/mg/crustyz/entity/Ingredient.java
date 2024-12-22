package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table( name = "ingredient" )
public class Ingredient {
    @Id
    @ColumnDefault( "nextval('ingredient_id_ingredient_seq')" )
    @Column( name = "id_ingredient", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
