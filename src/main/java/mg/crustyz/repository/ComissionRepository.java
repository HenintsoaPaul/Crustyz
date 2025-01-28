package mg.crustyz.repository;

import mg.crustyz.entity.emp.Comission;
import mg.crustyz.entity.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ComissionRepository extends JpaRepository<Comission, Integer> {
    @Query(value = """
                select c from Comission c where c.sale.employee.employeeSexe.id = :sexeId
            """)
    List<Comission> findAllComissionsByEmployeeSexe( int sexeId );

    @Query(value = """
			select s from Comission s where s.sale.daty >= :dateMin
			""")
    List<Comission> findAllComissionsAfterDateMin(LocalDate dateMin);

    @Query(value = """
			select s from Comission s where s.sale.daty <= :dateMax
			""")
    List<Comission> findAllComissionsBeforeDateMax(LocalDate dateMax);
}
