package sys.beans;

import sys.entities.CategoryEntity;
import sys.entities.ProductEntity;
import sys.entities.ShopEntity;

import java.util.List;

public class ShopHomeBean {

    private ShopEntity shop;

    private List<ProductEntity> featuredproducts;

    private List<CategoryEntity> categories;

    public ShopHomeBean(ShopEntity shop, List<ProductEntity> featuredproducts, List<CategoryEntity> categories) {
        this.shop = shop;
        this.featuredproducts = featuredproducts;
        this.categories = categories;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public List<ProductEntity> getFeaturedproducts() {
        return featuredproducts;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

}
