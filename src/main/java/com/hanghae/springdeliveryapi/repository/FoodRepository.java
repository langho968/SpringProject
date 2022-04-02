package com.hanghae.springdeliveryapi.repository;

import com.hanghae.springdeliveryapi.domain.Food;
import com.hanghae.springdeliveryapi.dto.FoodDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByRestaurantIdAndName(Long restaurantId, String name);
    List<Food> findAllByRestaurantId(Long restaurantId);

}
