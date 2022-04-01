package com.hanghae.springdeliveryapi.controller;


import com.hanghae.springdeliveryapi.domain.Restaurant;
import com.hanghae.springdeliveryapi.dto.RestaurantDto;
import com.hanghae.springdeliveryapi.repository.RestaurantRepository;
import com.hanghae.springdeliveryapi.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;


    //음식점 등록
   @PostMapping("/restaurant/register")
    public  Restaurant registerRestaurant(@RequestBody RestaurantDto requestDto){
        if(restaurantService.registerRestaurant(requestDto).equals("")){
            Restaurant restaurant = new Restaurant(requestDto);
//            restaurantRepository.save(restaurant);
            return restaurantRepository.save(restaurant);

        }else{
            String error = restaurantService.registerRestaurant(requestDto);
            throw new IllegalStateException(error);

        }

   }

    //음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

}
