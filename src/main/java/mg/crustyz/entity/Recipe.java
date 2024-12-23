package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table( name = "recipe" )
public class Recipe {
    @Id
    @ColumnDefault( "nextval('recipe_id_recipe_seq')" )
    @Column( name = "id_recipe", nullable = false )
    private Integer id;

    @Column( name = "name", length = 50 )
    private String name;

    @Column( name = "description", length = Integer.MAX_VALUE )
    private String description;

}
