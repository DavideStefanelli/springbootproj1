package sys.services;

import sys.entities.ProductEntity;

import java.util.List;

public interface IShopService {

    List<ProductEntity> getShopProducts(Integer shopId);

}
