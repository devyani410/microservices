package com.microservice.orderService.model;

import lombok.*;
//import org.hibernate.annotations.Table;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order_list_Items1")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class OrderListItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String skucode;
    private BigDecimal price;
    private Integer quantity;
}
