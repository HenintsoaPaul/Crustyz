package mg.crustyz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table( name = "employee_type" )
public class EmployeeType {
    @Id
    @ColumnDefault( "nextval('employee_type_id_employee_type_seq')" )
    @Column( name = "id_employee_type", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
