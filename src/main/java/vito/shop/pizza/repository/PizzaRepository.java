package vito.shop.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vito.shop.pizza.entity.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
