package com.hanghae.springdeliveryapi.service;


import com.hanghae.springdeliveryapi.domain.Food;
import com.hanghae.springdeliveryapi.dto.FoodDto;
import com.hanghae.springdeliveryapi.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Service

public class FoodService {
    private final FoodRepository foodRepository;

    public void registerFood(Long restaurantId, List<FoodDto> requestDto) {
        //음식 가격
        for (FoodDto foodDto : requestDto) {
            if (foodDto.getPrice() < 100 || foodDto.getPrice() > 1000000) {
                throw new IllegalStateException();
            } else if (foodDto.getPrice() % 100 != 0) {
                throw new IllegalStateException();
            }
            //음식 이름 중복
            List<Food> foodList = foodRepository.findAllByRestaurantIdAndName(restaurantId, foodDto.getName());
            if (foodList.size() > 0) {
                throw new IllegalStateException();
            }


            Food food = new Food(foodDto, restaurantId);
            foodRepository.save(food);
        }
    }
}
