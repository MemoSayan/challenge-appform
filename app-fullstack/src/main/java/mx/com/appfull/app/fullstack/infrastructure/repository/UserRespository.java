package mx.com.appfull.app.fullstack.infrastructure.repository;

import mx.com.appfull.app.fullstack.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Long>, UserRespositoryCustom {

}
