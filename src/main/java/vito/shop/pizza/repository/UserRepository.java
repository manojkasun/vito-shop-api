package vito.shop.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vito.shop.pizza.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email); //check the email is already in the table
    Optional<User> findByEmail(String email);
}