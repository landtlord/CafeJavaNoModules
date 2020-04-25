package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.controller.DTO.WaiterDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderControllerTest {
    private OrderController orderController = new OrderController();
    private WaiterController waiterController = new WaiterController();

    @Test
    void getOrderLinesFor() {
    }

    @Test
    void payOrder() {
    }

    @Test
    void addOrderLinesToOrder() {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        WaiterDTO waiterDTO = new WaiterDTO();
        waiterDTO.setId(1);
        orderLineDTO.setBeverageDTO(orderController.getBeverageDTOs().get(0));
        orderLineDTO.setWaiterDTO(waiterDTO);
        orderLineDTO.setQuantity(5);
        orderController.addOrderLinesToOrder(List.of(orderLineDTO), 99, waiterDTO);
    }
}