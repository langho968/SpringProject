package com.hanghae.springdeliveryapi.dto;

import com.hanghae.springdeliveryapi.domain.FoodOrderItems;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderItems> foods;
}
