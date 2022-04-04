package com.hanghae.springdeliveryapi.dto;

import com.hanghae.springdeliveryapi.domain.Food;
import com.hanghae.springdeliveryapi.domain.FoodOrderItems;
import com.hanghae.springdeliveryapi.domain.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {
    private String name;
    private int quantity;
    private int price;
    private int deliverFee;

    public FoodOrderDto(FoodOrderItems foodOrderItems1, Food food, Restaurant restaurant){
        this.name = foodOrderItems1.getName();
        this.quantity = foodOrderItems1.getQuantity();
        this.price = foodOrderItems1.getPrice();
        this.deliverFee = restaurant.getDeliveryFee();
    }
}
