package com.hanghae.springdeliveryapi.dto;

import com.hanghae.springdeliveryapi.domain.FoodOrder;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderResponseDto {
    private String restaurantName;
    private List<FoodsResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderResponseDto(FoodOrder foodOrder, int deliveryFee, List<FoodsResponseDto> foodsResponseDtoList){
        this.restaurantName = foodOrder.getRestaurantName();
        this.foods = foodsResponseDtoList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = foodOrder.getTotalPrice();
    }
}
