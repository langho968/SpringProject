package com.hanghae.springdeliveryapi.service;


import com.hanghae.springdeliveryapi.domain.Food;
import com.hanghae.springdeliveryapi.dto.FoodDto;
import com.hanghae.springdeliveryapi.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;
    public String  registerFood(Long restaurantId, FoodDto requestDto){
        String error = "";
        String name = requestDto.getName();
        int price = requestDto.getPrice();

        Optional<Food> foundId = foodRepository.findAllByRestaurantId(restaurantId);
        Optional<Food> foundName = foodRepository.findAllByName(name);

        if(price<100 || price>1000000){
            return "음식의 가격은 100원 이상 1,000,000원 이하여야합니다.";
        }else if(price%100 !=0){
            return "음식의 가격은 100원 단위로만 입력이 가능합니다";
        }
        if(foundId.isPresent()){
            if(foundName.isPresent()){
                return "이미 같은 이름의 음식이 존재합니다.";
            }
        }
        return error;
    }
}
