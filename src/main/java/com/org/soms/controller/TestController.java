package com.org.soms.controller;

import com.org.soms.dto.OrderDTO;
import com.org.soms.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private MapperFacade mapper;

    @RequestMapping("/test")
    public String test(){
        log.info("Test method called:)");
        return "Welcome to SOMS";
    }

    @RequestMapping("/test2")
    public String test2(){
        log.info("Test2 method called:)");
        return "Welcome to SOMS Test";
    }

    @PostMapping("/mapTest")
    public String mappingTest(@RequestBody OrderDTO orderDTO){

        log.info("OrderDTO Received : {} ",orderDTO);

        OrderEntity orderEntity = mapper.map(orderDTO, OrderEntity.class);

        log.info("OrderDto Converted to OrderEntity {}",orderEntity);

        return orderEntity.toString();

    }

}
