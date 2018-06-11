package sys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sys.entities.ProductEntity;
import sys.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {


    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductEntity getProductById(Integer id) {
        return productRepository.findById(id).get();
    }
}
