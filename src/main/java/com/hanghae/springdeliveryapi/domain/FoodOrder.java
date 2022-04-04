package com.hanghae.springdeliveryapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false)
    private String restaurantName;


    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @OneToMany
    @JoinColumn(name = "foodOrders_id")
    private List<FoodOrderItems> foods;

    public FoodOrder(Restaurant restaurant, int totalPrice, List<FoodOrderItems> foodOrderItems1){
        this.restaurantName = restaurant.getName();
        this.totalPrice = totalPrice;
        this.foods = foodOrderItems1;
        this.deliveryFee = restaurant.getDeliveryFee();
    }
}
