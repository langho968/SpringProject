package com.hanghae.springdeliveryapi.repository;

import com.hanghae.springdeliveryapi.domain.FoodOrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderItemsRepository extends JpaRepository<FoodOrderItems, Long> {
}
