package vito.shop.pizza.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vito.shop.pizza.entity.Pizza;
import vito.shop.pizza.payload.PizzaDto;
import vito.shop.pizza.payload.PizzaResponse;
import vito.shop.pizza.repository.PizzaRepository;
import vito.shop.pizza.service.PizzaService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;

    private ModelMapper mapper;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, ModelMapper mapper) {
        this.pizzaRepository = pizzaRepository;
        this.mapper = mapper;
    }

    @Override
    public PizzaResponse getAllPizzas(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        //create a pageable instance
        Pageable pageable =  PageRequest.of(pageNo, pageSize, sort);
        Page<Pizza> pizzas = pizzaRepository.findAll(pageable);
        //get content for page object

        List<Pizza> listOfPizzas = pizzas .getContent();
        List<PizzaDto> content =  listOfPizzas.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        PizzaResponse pizzaResponse = new PizzaResponse();
        pizzaResponse.setContent(content);
        pizzaResponse.setPageNo(pizzas.getNumber());
        pizzaResponse.setPageSize(pizzas.getSize());
        pizzaResponse.setTotalElements(pizzas.getTotalElements());
        pizzaResponse.setTotalPages(pizzas.getTotalPages());
        pizzaResponse.setLast(pizzas.isLast());
        return pizzaResponse;
    }

    @Override
    public List<PizzaDto> getAll() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        return pizzas.stream().map(pizza -> mapToDto(pizza)).collect(Collectors.toList());
    }


    private PizzaDto mapToDto(Pizza pizza){
        PizzaDto pizzaDto = mapper.map(pizza, PizzaDto.class);
        return pizzaDto;
    }

}
