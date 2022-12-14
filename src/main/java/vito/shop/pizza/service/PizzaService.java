package vito.shop.pizza.service;

import vito.shop.pizza.entity.Pizza;
import vito.shop.pizza.payload.PizzaDto;
import vito.shop.pizza.payload.PizzaResponse;

import java.util.List;

public interface PizzaService {

    PizzaResponse getAllPizzas(int pageNo, int pageSize, String sortBy, String sortDir);
    List<PizzaDto> getAll();
    PizzaDto getPizzaById(Long id);
    Pizza getById(Long id);
}
