package vito.shop.pizza.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pizza {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
        private Long id;
        private String name;
        private String type;
        private String ingredients;
        private String description;
        private String imageUrl;

}


