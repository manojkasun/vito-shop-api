package vito.shop.pizza.service;

import vito.shop.pizza.entity.User;

public interface UserService {
    User registerUser(User user);
    User getById(Long id);
}
