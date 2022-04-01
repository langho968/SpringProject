package com.hanghae.springdeliveryapi.controller;


import com.hanghae.springdeliveryapi.domain.Food;
import com.hanghae.springdeliveryapi.dto.FoodDto;
import com.hanghae.springdeliveryapi.repository.FoodRepository;
import com.hanghae.springdeliveryapi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodRepository foodRepository;
    private final FoodService foodService;


    // 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public Food registerFood(@PathVariable Long restaurantId, @RequestBody FoodDto requestDto){
        if(foodService.registerFood(restaurantId,requestDto).equals("")){
            Food food = new Food(requestDto);
            return foodRepository.save(food);
        }else{
            String error = foodService.registerFood(restaurantId, requestDto);
            throw new IllegalStateException(error);
        }
    }
    //메뉴판 조회
    @GetMapping("/restaurant/{restaurantID}/foods")
    public Optional<Food> getFoods(@PathVariable Long restaurantID){
        return foodRepository.findAllByRestaurantId(restaurantID);
    }
}
