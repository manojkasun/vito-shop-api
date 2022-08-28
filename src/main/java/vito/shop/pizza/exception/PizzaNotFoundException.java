package vito.shop.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PizzaNotFoundException extends RuntimeException{

    public PizzaNotFoundException() {
        super("Pizza is Not Available No!!!");
    }
}
