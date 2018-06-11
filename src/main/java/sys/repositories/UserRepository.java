package sys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import sys.entities.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer>, UserRepositoryCustom {

    UserEntity findByEmail(@Param("email") String email);
    List<UserEntity> findAll();
}
