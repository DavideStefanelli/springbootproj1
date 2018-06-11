package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sys.entities.ShopEntity;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer> {

}
