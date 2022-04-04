package com.hanghae.springdeliveryapi.controller;



import com.hanghae.springdeliveryapi.domain.FoodOrder;
import com.hanghae.springdeliveryapi.dto.OrderDto;
import com.hanghae.springdeliveryapi.dto.OrderRequestDto;
import com.hanghae.springdeliveryapi.repository.FoodOrderItemsRepository;
import com.hanghae.springdeliveryapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;
    private final FoodOrderItemsRepository foodsRepository;

    @PostMapping("/order/request")
    public FoodOrder order(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.order(orderRequestDto);
    }
}
