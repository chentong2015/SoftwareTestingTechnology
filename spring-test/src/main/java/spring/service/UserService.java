package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String getUserId(long id) {
        return userRepository.getUserNameById(id);
    }
}
