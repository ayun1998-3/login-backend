package com.testing.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.web.bind.annotation.RequestMapping;
@Service
public class UserService {

    private final UserRepository userRepository;
    private final int userId = 3;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

        // store
        userRepository.store(new User(1,"Austen", "00000", 9));
        userRepository.store(new User(2,"Kenneth", "11111", 10));
        userRepository.store(new User(3,"Brian", "traaa", 30));
    }
    //Business logic layer
    public User getUser() {
//        return new User("austen","0888800088",18);
        return userRepository.retrieve(userId);
    }

}
