package spring.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    String getUserNameById(long id);
}
