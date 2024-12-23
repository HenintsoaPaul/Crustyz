package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table( name = "promotion" )
public class Promotion {
    @Id
    @ColumnDefault( "nextval('promotion_id_promotion_seq')" )
    @Column( name = "id_promotion", nullable = false )
    private Integer id;

    @Column( name = "beginning_daty", nullable = false )
    private Instant beginningDaty;

    @Column( name = "ending_daty", nullable = false )
    private Instant endingDaty;

}
