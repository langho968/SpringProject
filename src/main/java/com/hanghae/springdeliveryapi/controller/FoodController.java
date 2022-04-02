package com.hanghae.springdeliveryapi.controller;


import com.hanghae.springdeliveryapi.domain.Food;
import com.hanghae.springdeliveryapi.dto.FoodDto;
import com.hanghae.springdeliveryapi.repository.FoodRepository;
import com.hanghae.springdeliveryapi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodRepository foodRepository;
    private final FoodService foodService;


    // 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> requestDto) {
        foodService.registerFood(restaurantId, requestDto);
    }

    //메뉴판 조회
    @GetMapping("/restaurant/{restaurantID}/foods")
    public List<Food> getFoods(@PathVariable Long restaurantID){
        return foodRepository.findAllByRestaurantId(restaurantID);
    }
}
