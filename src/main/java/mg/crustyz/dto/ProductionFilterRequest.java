package mg.crustyz.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductionFilterRequest {
    private  final List<Integer> ingredientIds;
    private  final List<Integer> productIds;
}
