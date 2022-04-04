package com.hanghae.springdeliveryapi.repository;

import com.hanghae.springdeliveryapi.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
        List<Restaurant> findAll();
        Restaurant findByName(String name);
}
