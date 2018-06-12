package sys.beans;

import sys.entities.ProductEntity;
import sys.entities.ShopEntity;

import java.util.List;

public class ShopHomeBean {

    private ShopEntity shop;

    private List<ProductEntity> featuredproducts;

    public ShopHomeBean(ShopEntity shop, List<ProductEntity> featuredproducts) {
        this.shop = shop;
        this.featuredproducts = featuredproducts;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public List<ProductEntity> getFeaturedproducts() {
        return featuredproducts;
    }

}
