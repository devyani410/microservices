package com.microservice.orderService.model;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Order1")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderListItems> orderListItemsList;
}
