package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import sys.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {

    UserEntity findByEmail(@Param("email") String email);
    
}
