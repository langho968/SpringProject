package com.hanghae.springdeliveryapi.dto;

import com.hanghae.springdeliveryapi.domain.FoodOrderItems;
import lombok.Getter;

@Getter
public class FoodsResponseDto {
    private String name;
    private int price;
    private int quantity;

    public FoodsResponseDto(FoodOrderItems foodOrderItems){
        this.name = foodOrderItems.getName();
        this.price = foodOrderItems.getPrice();
        this.quantity = foodOrderItems.getQuantity();
    }
}
