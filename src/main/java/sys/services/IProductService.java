package sys.services;

import sys.entities.ProductEntity;

public interface IProductService {

    ProductEntity getProductById(Integer id);

}
