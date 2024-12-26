package mg.crustyz.entity.emp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "employee_type" )
public class EmployeeType {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_employee_type", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
