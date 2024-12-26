package mg.crustyz.service;

import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.stock.ProductStock;
import mg.crustyz.entity.stock.MvtProductStock;
import mg.crustyz.repository.stock.ProductStockRepository;
import mg.crustyz.repository.stock.MvtProductStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductStockService {
    private final ProductStockRepository productStockRepository;
    private final MvtProductStockRepository mvtProductStockRepository;

    public List<ProductStock> findAll() {
        return productStockRepository.findAll();
    }

    public ProductStock findById( int id )
            throws Exception {
        return productStockRepository.findById( id )
                .orElseThrow( () -> new Exception( "ProductStock not found" ) );
    }

    public List<MvtProductStock> findAllMvtByIdProduct( int idProduct ) {
        return mvtProductStockRepository.getByIdProduct( idProduct );
    }
}
