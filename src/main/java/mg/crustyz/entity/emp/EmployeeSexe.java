package mg.crustyz.entity.emp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "employee_sexe" )
public class EmployeeSexe {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_employee_sexe", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
