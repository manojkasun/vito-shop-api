package vito.shop.pizza.payload;

import lombok.Data;

@Data
public class PizzaDto {

    private Long id;
    private String name;
    private String type;
    private String ingredients;
    private String description;
    private String imageUrl;
}
