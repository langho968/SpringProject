package com.hanghae.springdeliveryapi.dto;

import lombok.Getter;

@Getter
public class OrdersResponseDto {
    private String name;
    private int price;
    private int quantity;

    public OrdersResponseDto()
}
