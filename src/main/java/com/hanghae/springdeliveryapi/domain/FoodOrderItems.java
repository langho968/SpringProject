package com.hanghae.springdeliveryapi.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class FoodOrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String name;


    public FoodOrderItems(FoodOrderItems foodOrderItems, Food food){
        this.quantity = foodOrderItems.getQuantity();;
        this.price = food.getPrice()* foodOrderItems.quantity;
        this.name = food.getName();
    }


}
