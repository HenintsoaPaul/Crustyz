package mg.crustyz.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.dto.SupplyDTO;
import mg.crustyz.entity.supply.Supply;
import mg.crustyz.entity.supply.SupplyDetail;
import mg.crustyz.repository.supply.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final SupplyDetailService supplyDetailService;

    public List<Supply> findAll() {
        return supplyRepository.findAll();
    }

    @Transactional
    public void save( SupplyDTO supplyDTO )
            throws Exception {
        Supply s = supplyRepository.save( supplyDTO.getSupply() );
        double totalPrice = 0;
        for ( SupplyDetail sd : supplyDTO.getSupplyDetails() ) {
            supplyDetailService.save( s, sd );
            totalPrice += sd.getPrice();
        }
        s.setTotalPrice( totalPrice );
        supplyRepository.save( s );
    }

    public Supply findById( Integer id ) {
        return supplyRepository.findById( id )
                .orElseThrow( () -> new RuntimeException( "Supply not found" ) );
    }

    public List<SupplyDetail> findAllDetails( Supply supply ) {
        return supplyDetailService.findAllBySupply( supply );
    }
}
