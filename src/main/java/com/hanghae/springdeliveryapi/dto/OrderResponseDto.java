package com.hanghae.springdeliveryapi.dto;

import com.hanghae.springdeliveryapi.domain.FoodOrder;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderDto(FoodOrder foodOrder, int deliveryFee, List<FoodOrderDto> foodOrderDtoList){
        this.restaurantName = foodOrder.getRestaurantName();
        this.foods = foodOrderDtoList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = foodOrder.getTotalPrice();
    }
}
