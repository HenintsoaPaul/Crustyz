package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.emp.Employee;
import mg.crustyz.entity.sale.Sale;

@Data
public class CommissionDTO {
    private final Employee employee;
    private final double totalCommission;
    private final double totalSales;

    private final double tauxCommission = (double) 5 /100;

    public CommissionDTO(Employee employee, double totalCommission) {
        this.employee = employee;
        this.totalCommission = totalCommission * tauxCommission;
        this.totalSales = totalCommission;
    }

    public String getFullName() {
        return this.employee.getName() + " " + this.employee.getFirstName();
    }
}
