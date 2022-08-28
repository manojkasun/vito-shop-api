package vito.shop.pizza.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import vito.shop.pizza.entity.Pizza;
import vito.shop.pizza.payload.PizzaDto;
import vito.shop.pizza.repository.PizzaRepository;
import vito.shop.pizza.service.PizzaService;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PizzaApplicationTests {

	private PizzaService pizzaService;

	@MockBean
	private PizzaRepository pizzaRepository;

	@BeforeEach
	void setup(){
		Optional<Pizza> pizza = Optional.of(new Pizza(3L, "abc", "abc@gmail.com", "045566656565","test dis", "img url"));
		Mockito.when(pizzaRepository.findById(1L)).thenReturn(pizza);
	}
	@Test
	public void testGetPizzaById_Success() {
		String pizza_name = "cheese pizza";
		PizzaDto pizza = pizzaService.getPizzaById(1L);
		assertEquals(pizza_name, pizza.getName() );
	}


}

