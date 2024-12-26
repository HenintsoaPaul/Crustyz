package mg.crustyz.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.entity.sale.SaleDetail;
import mg.crustyz.repository.sale.SaleDetailRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleDetailService {
    private final SaleDetailRepository saleDetailRepository;
    private final ProductStockService productStockService;

    @Transactional
    public SaleDetail save( Sale mother, SaleDetail saleDetail )
            throws Exception {
        double price = saleDetail.getProduct().getUnitPrice() * saleDetail.getQuantity();
        saleDetail.setPrice( price );

        saleDetail.setSale( mother );
        productStockService.saveMvtStock( saleDetail );

        return saleDetailRepository.save( saleDetail );
    }
}
