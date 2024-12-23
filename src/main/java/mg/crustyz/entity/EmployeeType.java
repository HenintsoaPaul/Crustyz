package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "employee_type" )
public class EmployeeType {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "employee_type_id_gen" )
    @SequenceGenerator( name = "employee_type_id_gen", sequenceName = "employee_type_id_employee_type_seq", allocationSize = 1 )
    @Column( name = "id_employee_type", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

}
