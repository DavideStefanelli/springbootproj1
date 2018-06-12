package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sys.entities.CategoryEntity;
import sys.entities.ProductEntity;
import sys.entities.ShopEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByCategoryAndShop(CategoryEntity category, ShopEntity shop);

}
