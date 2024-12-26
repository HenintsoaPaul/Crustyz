package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.entity.sale.SaleDetail;

import java.util.ArrayList;
import java.util.List;


@Data
public class SaleDTO {
    private Sale sale;
    private List<SaleDetail> saleDetails;

    public SaleDTO() {
        this.saleDetails = new ArrayList<>();
        this.saleDetails.add(new SaleDetail());
    }
}
