package vito.shop.pizza.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vito.shop.pizza.entity.User;
import vito.shop.pizza.repository.UserRepository;
import vito.shop.pizza.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    //register ne customers
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user){
        // add check for email exist in the database

        if(userRepository.existsByEmail(user.getEmail())){
            return new ResponseEntity<>("Email Already taken!!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

//login customer



}

