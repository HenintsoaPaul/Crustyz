package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.supply.Supply;
import mg.crustyz.entity.supply.SupplyDetail;

import java.util.ArrayList;
import java.util.List;


@Data
public class SupplyDTO {
    private Supply supply;
    private List<SupplyDetail> supplyDetails = new ArrayList<>();

    public SupplyDTO() {
        this.supplyDetails.add( new SupplyDetail() );
    }
}
