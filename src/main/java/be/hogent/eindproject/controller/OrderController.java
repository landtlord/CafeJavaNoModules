package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.controller.DTO.WaiterDTO;
import be.hogent.eindproject.controller.DTO.mappers.BeverageMapper;
import be.hogent.eindproject.controller.DTO.mappers.OrderMapper;
import be.hogent.eindproject.model.model.Order;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderController extends Controller {

    private List<BeverageDTO> beverageDTOs;

    public OrderController() {
        super();
        beverageDTOs = beverageRepository.getAllBeverages()
                .stream()
                .map(BeverageMapper::mapToBeverageDTO)
                .collect(Collectors.toList());
    }

    public List<BeverageDTO> getBeverageDTOs() {
        return beverageDTOs;
    }

    public List<OrderLineDTO> getOrderLinesFor(int tableNumber) {
        try {
            return orderRepository
                    .getOpenOrderFor(tableNumber)
                    .getOrderLines()
                    .stream()
                    .map(OrderMapper::mapToOrderDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public void payOrder(int tableNumber) {
        orderRepository.payOpenOrderFor(tableNumber);
    }

    public void addOrderLinesToOrder(List<OrderLineDTO> orderLineDTOS, int tableNumber, WaiterDTO waiterDTO) {
        Order openOrderOnTable = orderRepository.getOpenOrderFor(tableNumber);
        if (openOrderOnTable == null) {
            orderRepository.addOrderOnTable(tableNumber, waiterDTO.getId());
            openOrderOnTable = orderRepository.getOpenOrderFor(tableNumber);
        }
        int orderNumber = openOrderOnTable.getID();
        orderLineDTOS.stream()
                .filter(orderLineDTO -> orderLineDTO.getQuantity() != 0)
                .map(OrderMapper::mapToOrderLine)
                .forEach(orderLine -> orderRepository.addOrderLineToOrder(orderLine, orderNumber));
    }
}
