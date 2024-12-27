package mg.crustyz.entity.emp;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Data
@Entity
@Table( name = "employee" )
public class Employee {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_employee", nullable = false )
    private Integer id;

    @Column( name = "name", nullable = false, length = 50 )
    private String name;

    @Column( name = "first_name", length = 50 )
    private String firstName;

    @Column( name = "cin", nullable = false, length = 50 )
    private String cin;

    @Column( name = "hire_date", nullable = false )
    private LocalDate hireDate;

    @Column( name = "salary", nullable = false )
    private double salary;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_employee_type", nullable = false )
    private EmployeeType employeeType;

}
