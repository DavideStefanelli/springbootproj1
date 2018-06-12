package sys.services;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sys.beans.ShopHomeBean;
import sys.entities.CategoryEntity;
import sys.entities.ProductEntity;
import sys.entities.ShopEntity;
import sys.repositories.CategoryRepository;
import sys.repositories.ProductRepository;
import sys.repositories.ShopRepository;
import java.util.List;

@Service
public class ShopService implements IShopService {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ShopHomeBean getShopHome(Integer shopId) {
        ShopEntity shopEntity = shopRepository.getOne(shopId);
        if(shopEntity != null) {
            return new ShopHomeBean(shopEntity, getFeaturedProducts(shopEntity), getShopCategories(shopEntity));
        } else {
            logger.warn("Shop with id " + shopId + " not found!");
            return null;
        }
    }

    public List<ProductEntity> getShopProducts(Integer shopId){
        ShopEntity shopEntity = shopRepository.getOne(shopId);
        if(shopEntity != null){
            return (List<ProductEntity>)shopEntity.getProducts();
        } else {
            logger.warn("Shop with id " + shopId + " not found!");
            return null;
        }
    }

    @Override
    public List<ProductEntity> getShopProductsByCategory(ShopEntity shopEntity, Integer categoryId) {
        CategoryEntity categoryEntity = categoryRepository.getOne(categoryId);
        if(categoryEntity != null) {
            return productRepository.findByCategoryAndShop(categoryEntity, shopEntity);
        } else {
            logger.warn("Category with id " + categoryId + " not found in shop " + shopEntity.getName() + " with id " + shopEntity.getId() + " !");
            return null;
        }
    }

    @Override
    public List<CategoryEntity> getShopCategories(ShopEntity shopEntity) {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductEntity> getFeaturedProducts(ShopEntity shopEntity) {
        return getShopProductsByCategory(shopEntity, 1);
        //TODO: Mostrare prodotti in base alle ricerche/interessi dell'utente
    }

}
