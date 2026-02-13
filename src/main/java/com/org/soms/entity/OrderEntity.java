package com.org.soms.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderEntity {

    private String customerId;

    private List<String> items;

    private String deliveryAddress;

    private String paymentMode;

}
