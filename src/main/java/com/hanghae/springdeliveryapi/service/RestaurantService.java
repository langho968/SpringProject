package com.hanghae.springdeliveryapi.service;


import com.hanghae.springdeliveryapi.domain.Restaurant;
import com.hanghae.springdeliveryapi.dto.RestaurantDto;
import com.hanghae.springdeliveryapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    public String registerRestaurant(RestaurantDto requestDto){
        String error = "";
        String name = requestDto.getName();
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        if(minOrderPrice< 1000 || minOrderPrice>100000){
           return "최소주문 가격은 1,000원 이상 100,000원 이하여야 합니다.";
        }else if(minOrderPrice % 100 != 0){
            return "최소주문 가격은 100원 단위로만 입력이 가능합니다.";
        }else if(deliveryFee<0 || deliveryFee>10000) {
            return"기본 배달비는 0원 이상 10,000 이하 여야 합니다.";
        }else if(deliveryFee % 500 !=0){
            return "기본 배달비는 500원 단위로만 입력이 가능합니다.";
        }
//        Restaurant restaurant = new Restaurant(name, minOrderPrice, deliveryFee);
//        restaurantRepository.save(restaurant);
        return error;
    }

}
