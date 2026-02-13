package com.org.soms.controller;

import com.org.soms.dto.OrderDTO;
import com.org.soms.entity.OrderEntity;
import ma.glasnost.orika.MapperFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TestControllerTest {

    @Mock
    private MapperFacade mapper;

    @InjectMocks
    private TestController controller;

    @Test
    void testEndpoint_returnsWelcome() {
        String result = controller.test();
        assertEquals("Welcome to SOMS", result);
    }

    @Test
    void mappingTest_maps_and_returnsEntityToString() {
        OrderDTO dto = new OrderDTO();
        OrderEntity entity = mock(OrderEntity.class);

        when(mapper.map(dto, OrderEntity.class)).thenReturn(entity);
        when(entity.toString()).thenReturn("expected-entity-string");

        String result = controller.mappingTest(dto);

        verify(mapper).map(dto, OrderEntity.class);
        assertEquals("expected-entity-string", result);
    }
}