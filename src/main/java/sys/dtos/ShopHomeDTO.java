package sys.dtos;

import java.util.List;

public class ShopHomeDTO extends BasicDTO {

    private ShopDTO shop;

    private List<ProductDTO> featuredproducts;

    private List<CategoryDTO> categories;

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }

    public List<ProductDTO> getFeaturedproducts() {
        return featuredproducts;
    }

    public void setFeaturedproducts(List<ProductDTO> featuredproducts) {
        this.featuredproducts = featuredproducts;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
