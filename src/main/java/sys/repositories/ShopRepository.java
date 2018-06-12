package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sys.entities.ProductEntity;
import sys.entities.ShopEntity;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer>, ShopRepositoryCustom {


}
