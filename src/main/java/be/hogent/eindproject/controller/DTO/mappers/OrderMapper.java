package be.hogent.eindproject.controller.DTO.mappers;

import be.hogent.eindproject.controller.DTO.OrderDTO;
import be.hogent.eindproject.model.model.Order;

public class OrderMapper {
    public static OrderDTO mapToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderNumber(order.getOrderNumber());
        orderDTO.setBeverageDTO(BeverageMapper.mapToBeverageDTO(order.getBeverage()));
        orderDTO.setQuantity(order.getQuantity());
        orderDTO.setDate(order.getDate());
        orderDTO.setWaiterDTO(WaiterMapper.mapToWaiterDTO(order.getWaiter()));
        return orderDTO;
    }

    public static Order mapToOrder(OrderDTO orderDTO) {
        return new Order(
                orderDTO.getId(),
                orderDTO.getOrderNumber(),
                BeverageMapper.mapToBeverage(orderDTO.getBeverageDTO()),
                orderDTO.getQuantity(),
                orderDTO.getDate(),
                WaiterMapper.mapToWaiter(orderDTO.getWaiterDTO())
        );
    }

}
