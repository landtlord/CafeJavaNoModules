package be.hogent.eindproject.controller.DTO.mappers;

import be.hogent.eindproject.controller.DTO.OrderDTO;
import be.hogent.eindproject.model.model.OrderLine;

public class OrderMapper {
    public static OrderDTO mapToOrderDTO(OrderLine orderLine) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderLine.getId());
        orderDTO.setOrderNumber(orderLine.getOrderNumber());
        orderDTO.setBeverageDTO(BeverageMapper.mapToBeverageDTO(orderLine.getBeverage()));
        orderDTO.setQuantity(orderLine.getQuantity());
        orderDTO.setDate(orderLine.getDate());
        orderDTO.setWaiterDTO(WaiterMapper.mapToWaiterDTO(orderLine.getWaiter()));
        return orderDTO;
    }

    public static OrderLine mapToOrder(OrderDTO orderDTO) {
        return new OrderLine(
                orderDTO.getId(),
                orderDTO.getOrderNumber(),
                BeverageMapper.mapToBeverage(orderDTO.getBeverageDTO()),
                orderDTO.getQuantity(),
                orderDTO.getDate(),
                WaiterMapper.mapToWaiter(orderDTO.getWaiterDTO())
        );
    }

}
