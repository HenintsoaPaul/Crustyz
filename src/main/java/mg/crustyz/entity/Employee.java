package mg.crustyz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table( name = "employee" )
public class Employee {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "employee_id_gen" )
    @SequenceGenerator( name = "employee_id_gen", sequenceName = "employee_id_employee_seq", allocationSize = 1 )
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

    @Column( name = "salary", nullable = false, precision = 15, scale = 2 )
    private BigDecimal salary;

    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "id_employee_type", nullable = false )
    private mg.crustyz.entity.EmployeeType idEmployeeType;

}
