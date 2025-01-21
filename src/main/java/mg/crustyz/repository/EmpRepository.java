package mg.crustyz.repository;

import mg.crustyz.entity.emp.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
