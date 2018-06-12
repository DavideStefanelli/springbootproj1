package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sys.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {


}
