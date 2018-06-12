package sys.services;

import sys.beans.ShopHomeBean;
import sys.dtos.ShopHomeDTO;
import sys.entities.ProductEntity;
import sys.entities.ShopEntity;

import java.util.List;

public interface IShopService {

    List<ProductEntity> getShopProducts(Integer shopId);
    List<ProductEntity> getShopProductsByCategory(ShopEntity shopEntity, Integer categoryId);

    ShopHomeBean getShopHome(Integer shopId);
    List<ProductEntity> getFeaturedProducts(ShopEntity shopEntity);
}
