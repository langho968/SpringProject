package com.hanghae.springdeliveryapi.repository;

import com.hanghae.springdeliveryapi.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findAllByRestaurantId(Long restaurantId);
    Optional<Food> findAllByName(String name);
}
