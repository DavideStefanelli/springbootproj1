package sys.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sys.entities.ProductEntity;
import sys.entities.ShopEntity;
import sys.repositories.ShopRepository;

import java.util.List;

@Service
public class ShopService implements IShopService {

    @Autowired
    ShopRepository shopRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<ProductEntity> getShopProducts(Integer shopId){
        ShopEntity shopEntity = shopRepository.findById(shopId).get();
        if(shopEntity != null){
            return (List<ProductEntity>)shopEntity.getProducts();
        } else {
            return null;
        }
    }


}
