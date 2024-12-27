package mg.crustyz.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.sale.SaleDetail;
import mg.crustyz.entity.stock.MvtStockType;
import mg.crustyz.entity.stock.ProductStock;
import mg.crustyz.entity.stock.MvtProductStock;
import mg.crustyz.repository.stock.MvtStockTypeRepository;
import mg.crustyz.repository.stock.ProductStockRepository;
import mg.crustyz.repository.stock.MvtProductStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductStockService {
    private final ProductStockRepository productStockRepository;
    private final MvtProductStockRepository mvtProductStockRepository;
    private final MvtStockTypeRepository mvtStockTypeRepository;

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

    @Transactional
    public void saveMvtStock( SaleDetail saleDetail )
            throws Exception {
        MvtProductStock mvt = new MvtProductStock();
        mvt.setQuantity( saleDetail.getQuantity() );
        mvt.setProduct( saleDetail.getProduct() );
        mvt.setDaty( saleDetail.getSale().getDaty() );

        MvtStockType type = mvtStockTypeRepository.findById( 1 )
                .orElseThrow( () -> new Exception( "MvtStockType not found" ) );
        mvt.setMvtStockType( type );

        mvtProductStockRepository.save( mvt );
    }
}
