package com.microservice.orderService.services;

import com.microservice.orderService.dto.OrderListItemsDto;
import com.microservice.orderService.dto.OrderRequest;
import com.microservice.orderService.model.Order;
import com.microservice.orderService.model.OrderListItems;
import com.microservice.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServices {
    private final OrderRepository orderRepository;

    public void save(OrderRequest orderRequest){
        List<OrderListItems> orderListItemsList=orderRequest.getOrderListItemsList().stream().
                map(this::mapDto).collect(Collectors.toList());
        Order order= Order.builder()
                .orderNumber(orderRequest.getOrderNumber())
                .orderListItemsList(orderListItemsList)
                .build();
        //call inventory service if the the product is available than place order


        orderRepository.save(order);
    }
    private OrderListItems mapDto(OrderListItemsDto orderListItemsDto){
        OrderListItems orderListItems=OrderListItems.builder().price(orderListItemsDto.getPrice())
                .skucode(orderListItemsDto.getSkucode())
                .quantity(orderListItemsDto.getQuantity())
                .build();
        return orderListItems;
    }

    public List<Order> get() {
        return orderRepository.findAll();
    }
}
