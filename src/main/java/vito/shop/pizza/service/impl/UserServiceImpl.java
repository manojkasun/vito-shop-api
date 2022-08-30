package vito.shop.pizza.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vito.shop.pizza.entity.User;
import vito.shop.pizza.repository.UserRepository;
import vito.shop.pizza.service.UserService;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {

        user.setPassword(passwordEncord(user.getPassword()));
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User getById(Long id) {
        User user = userRepository.getById(id);
        return user;
    }

    public String passwordEncord(String password){
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

}

