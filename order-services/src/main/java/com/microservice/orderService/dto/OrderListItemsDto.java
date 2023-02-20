package com.microservice.orderService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderListItemsDto {
    private String skucode;
    private BigDecimal price;
    private Integer quantity;
}

