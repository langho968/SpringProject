package com.hanghae.springdeliveryapi.domain;


import com.hanghae.springdeliveryapi.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(Long restaurantId, String name, int price){
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }

    public Food(FoodDto requestDto){
        this.restaurantId = requestDto.getRestaurantId();
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
