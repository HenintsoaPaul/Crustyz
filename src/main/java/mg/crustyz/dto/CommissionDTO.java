package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.emp.Employee;
import mg.crustyz.entity.sale.Sale;

@Data
public class CommissionDTO {
    private final Employee employee;
    private final double totalCommission;

    // private final double tauxCommission;

    private final double tauxCommission = 5/100;

    public CommissionDTO(Sale sale) {
        this.employee = sale.getEmployee();
        this.totalCommission = sale.getTotalPrice() * tauxCommission;
    }
}
