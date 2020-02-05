package be.hogent.eindproject.controller.mappers;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderDTO;
import be.hogent.eindproject.controller.DTO.WaiterDTO;
import be.hogent.eindproject.controller.DTO.mappers.BeverageMapper;
import be.hogent.eindproject.controller.DTO.mappers.OrderMapper;
import be.hogent.eindproject.controller.DTO.mappers.WaiterMapper;
import be.hogent.eindproject.model.model.Beverage;
import be.hogent.eindproject.model.model.Order;
import be.hogent.eindproject.model.model.Waiter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderMapperTest {

    @Test
    void givenOrder_whenMapToOrderDTO_thenTheCorrectOrderDTOIsProvided() {
        //given
        int id = 1;
        int orderNumber = 2;
        Beverage beverage = new Beverage(1, "Cola", 2.40);
        int quantity = 3;
        LocalDate date = LocalDate.now();
        Waiter waiter = new Waiter(1, "Vermeulen", "Joske", "GeRaadHetNooit");
        Order order = new Order(id, orderNumber, beverage, quantity, date, waiter);

        //when
        OrderDTO orderDTO = OrderMapper.mapToOrderDTO(order);

        //then
        assertEquals(id, orderDTO.getId());
        assertEquals(orderNumber, orderDTO.getOrderNumber());
        assertEquals(BeverageMapper.mapToBeverageDTO(beverage), orderDTO.getBeverageDTO());
        assertEquals(quantity, orderDTO.getQuantity());
        assertEquals(date, orderDTO.getDate());
        assertEquals(WaiterMapper.mapToWaiterDTO(waiter), orderDTO.getWaiterDTO());
    }

    @Test
    void givenOrderDTO_whenMapToOrder_thenTheCorrectOrderIsProvided() {
        //given
        int id = 1;
        int orderNumber = 2;
        BeverageDTO beverageDTO = getBeverageDTO();
        int quantity = 3;
        LocalDate date = LocalDate.now();
        WaiterDTO waiterDTO = getWaiterDTO();
        OrderDTO orderDTO = getOrderDTO(id, orderNumber, beverageDTO, quantity, date, waiterDTO);

        //when
        Order order = OrderMapper.mapToOrder(orderDTO);

        //then
        assertEquals(id, order.getId());
        assertEquals(orderNumber, order.getOrderNumber());
        assertEquals(BeverageMapper.mapToBeverage(beverageDTO), order.getBeverage());
        assertEquals(quantity, order.getQuantity());
        assertEquals(date, order.getDate());
        assertEquals(WaiterMapper.mapToWaiter(waiterDTO), order.getWaiter());
    }

    private OrderDTO getOrderDTO(int id, int orderNumber, BeverageDTO beverageDTO, int quantity, LocalDate date, WaiterDTO waiterDTO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(id);
        orderDTO.setOrderNumber(orderNumber);
        orderDTO.setBeverageDTO(beverageDTO);
        orderDTO.setQuantity(quantity);
        orderDTO.setDate(date);
        orderDTO.setWaiterDTO(waiterDTO);
        return orderDTO;
    }

    private WaiterDTO getWaiterDTO() {
        WaiterDTO waiterDTO = new WaiterDTO();
        waiterDTO.setId(1);
        waiterDTO.setFirstName("Joske");
        waiterDTO.setLastName("Vermeulen");
        waiterDTO.setPassword("GeRaadHetNooit");
        return waiterDTO;
    }

    private BeverageDTO getBeverageDTO() {
        BeverageDTO beverageDTO = new BeverageDTO();
        beverageDTO.setBeverageID(1);
        beverageDTO.setBeverageName("Cola");
        beverageDTO.setPrice(2.40);
        return beverageDTO;
    }
}