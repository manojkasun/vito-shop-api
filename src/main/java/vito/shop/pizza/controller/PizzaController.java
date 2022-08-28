package vito.shop.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vito.shop.pizza.payload.PizzaDto;
import vito.shop.pizza.payload.PizzaResponse;
import vito.shop.pizza.repository.PizzaRepository;
import vito.shop.pizza.service.PizzaService;
import vito.shop.pizza.utils.AppConstraints;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    private PizzaService pizzaService;


    
    //get all pizza endpoint
    @GetMapping("all")
    public PizzaResponse getAllPizzas(
            @RequestParam(value = "pageNo", defaultValue= AppConstraints.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstraints.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstraints.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstraints.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return pizzaService.getAllPizzas(pageNo, pageSize, sortBy,sortDir);
    }

    @GetMapping
    public List<PizzaDto> getAllPizza(){
        return pizzaService.getAll();
    }


}
