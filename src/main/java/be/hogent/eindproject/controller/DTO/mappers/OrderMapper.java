package be.hogent.eindproject.controller.DTO.mappers;

import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.model.model.OrderLine;

public class OrderMapper {
    public static OrderLineDTO mapToOrderDTO(OrderLine orderLine) {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setId(orderLine.getId());
        orderLineDTO.setOrderNumber(orderLine.getOrderNumber());
        orderLineDTO.setBeverageDTO(BeverageMapper.mapToBeverageDTO(orderLine.getBeverage()));
        orderLineDTO.setQuantity(orderLine.getQuantity());

        return orderLineDTO;
    }

    public static OrderLine mapToOrder(OrderLineDTO orderLineDTO) {
        return new OrderLine(
                orderLineDTO.getId(),
                orderLineDTO.getOrderNumber(),
                BeverageMapper.mapToBeverage(orderLineDTO.getBeverageDTO()),
                orderLineDTO.getQuantity()
        );
    }

}
