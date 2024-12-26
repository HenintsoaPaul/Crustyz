package mg.crustyz.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.SaleDTO;
import mg.crustyz.entity.sale.Sale;
import mg.crustyz.entity.sale.SaleDetail;
import mg.crustyz.repository.sale.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;
    private final SaleDetailService saleDetailService;

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Transactional
    public void save( SaleDTO saleDTO )
            throws Exception {
        Sale s = saleRepository.save( saleDTO.getSale() );
        double totalPrice = 0;
        for ( SaleDetail sd: saleDTO.getSaleDetails() ) {
            saleDetailService.save( s, sd );
            totalPrice += sd.getPrice();
        }
        s.setTotalPrice( totalPrice );
        saleRepository.save( s );
    }
}
