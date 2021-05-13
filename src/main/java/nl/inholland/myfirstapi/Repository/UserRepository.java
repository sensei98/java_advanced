package nl.inholland.myfirstapi.Repository;

import nl.inholland.myfirstapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByUsername(String username);

}
