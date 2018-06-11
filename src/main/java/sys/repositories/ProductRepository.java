package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sys.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
