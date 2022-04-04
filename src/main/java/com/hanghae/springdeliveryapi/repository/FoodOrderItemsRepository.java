package com.hanghae.springdeliveryapi.repository;

import com.hanghae.springdeliveryapi.domain.FoodOrder;
import com.hanghae.springdeliveryapi.domain.FoodOrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodOrderItemsRepository extends JpaRepository<FoodOrderItems, Long> {
//    List<FoodOrderItems> findFoodOrderItemsByfoodOrders_id(FoodOrder foodOrder);
}
