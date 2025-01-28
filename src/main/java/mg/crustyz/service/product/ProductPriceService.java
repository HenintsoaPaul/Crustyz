package mg.crustyz.service.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mg.crustyz.entity.product.Product;
import mg.crustyz.entity.product.ProductPrice;
import mg.crustyz.repository.product.ProductPriceRepository;
import mg.crustyz.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;

    public List<ProductPrice> findAll() {
        return productPriceRepository.findAll();
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Transactional
    public void save(ProductPrice productPrice)
            throws Exception {
        // TODO: update prix produit
        Integer id = productPrice.getProduct().getId();
        Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));
        product.setUnitPrice(productPrice.getVal());
        productRepository.save(product);
        // TODO: update prix produit

        productPriceRepository.save(productPrice);
    }

    public ProductPrice findById(Integer id) throws Exception {
        return productPriceRepository.findById(id).orElseThrow(() -> new Exception("ProductPrice not found"));
    }
}
