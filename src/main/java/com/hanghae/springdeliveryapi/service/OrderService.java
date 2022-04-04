package com.hanghae.springdeliveryapi.service;

import com.hanghae.springdeliveryapi.domain.Food;
import com.hanghae.springdeliveryapi.domain.FoodOrder;
import com.hanghae.springdeliveryapi.domain.FoodOrderItems;
import com.hanghae.springdeliveryapi.domain.Restaurant;
import com.hanghae.springdeliveryapi.dto.*;
import com.hanghae.springdeliveryapi.repository.FoodOrderItemsRepository;
import com.hanghae.springdeliveryapi.repository.FoodOrderRepository;
import com.hanghae.springdeliveryapi.repository.FoodRepository;
import com.hanghae.springdeliveryapi.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {


    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodsRepository;
    private final FoodOrderItemsRepository foodOrderItemsRepository;
    private final FoodOrderRepository foodOrderRepository;

    public FoodOrder order(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException()
        );

        List<FoodOrderItems> foodOrderList = orderRequestDto.getFoods();
        List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
        List<FoodOrderItems> foodOrderItemsList1 = new ArrayList<>();
        int totalPrice = 0;
        System.out.println(foodOrderList);
        for (FoodOrderItems foodOrderItems : foodOrderList) {

            int quantity = foodOrderItems.getQuantity();
            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException();
            }
            Food food = getFood(foodOrderItems);
            food.getId();
            System.out.println(food.getName());
            System.out.println(food.getPrice());

            FoodOrderItems foodOrderItems1 = new FoodOrderItems(foodOrderItems, food);
            foodOrderItemsRepository.save(foodOrderItems1);
            FoodOrderDto foodOrderDto = new FoodOrderDto(foodOrderItems, food, restaurant);
            foodOrderDtoList.add(foodOrderDto);
            totalPrice += food.getPrice()*quantity;
            foodOrderItemsList1.add(foodOrderItems1);

        }

        if(totalPrice < restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException();
        }
        int deliveryFee = restaurant.getDeliveryFee();
        totalPrice += deliveryFee;
        FoodOrder foodOrder = new FoodOrder(restaurant, totalPrice, foodOrderItemsList1);
//        foodOrderRepository.save(foodOrder);
//        OrderDto orderDto = new OrderDto(foodOrder, deliverFee, foodOrderDtoList);
        System.out.println(foodOrder.getDeliveryFee());
        return foodOrder;

    }

    private Restaurant getRestaurant(OrderRequestDto orderRequestDto) {

        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException()
        );
        return restaurant;
    }
    private Food getFood(com.hanghae.springdeliveryapi.domain.FoodOrderItems foodOrderItems){
        return foodsRepository.findById(foodOrderItems.getId()).orElseThrow(
                ()-> new IllegalArgumentException()
        );
    }
}