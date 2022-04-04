package com.hanghae.springdeliveryapi.repository;

import com.hanghae.springdeliveryapi.domain.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository <FoodOrder, Long>{
}
