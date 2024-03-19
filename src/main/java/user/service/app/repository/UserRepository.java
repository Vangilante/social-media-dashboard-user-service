package user.service.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import user.service.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByUsername(String username);
}
