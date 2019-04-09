package it.tdgroup.eroi.repository;

import it.tdgroup.eroi.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "userRepository")
public interface UserRepository extends MongoRepository<User, String> {

    User findByFirstName(String firstName);


}
