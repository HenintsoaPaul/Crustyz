package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.entity.sale.SaleDetail;

import java.util.ArrayList;
import java.util.List;


@Data
public class SaleDTO {
    private Sale sale;
    private List<SaleDetail> saleDetails = new ArrayList<>();

    public SaleDTO() {
        this.saleDetails.add( new SaleDetail() );
    }
}
