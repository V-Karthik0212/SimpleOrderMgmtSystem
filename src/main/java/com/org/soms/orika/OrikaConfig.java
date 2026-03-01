package com.org.soms.orika;

import com.org.soms.dto.OrderDTO;
import com.org.soms.entity.OrderEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaConfig {

    @Bean
    public MapperFactory mapperFactory(){

        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(OrderEntity.class, OrderDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(OrderDTO.class, OrderEntity.class)
                .byDefault()
                .register();
        return mapperFactory;
    }

    @Bean
    public MapperFacade mapperFacade(MapperFactory factory){

        return factory.getMapperFacade();
    }


}
