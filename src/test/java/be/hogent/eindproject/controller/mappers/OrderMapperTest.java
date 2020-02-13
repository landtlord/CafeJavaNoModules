package be.hogent.eindproject.controller.mappers;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.controller.DTO.WaiterDTO;
import be.hogent.eindproject.controller.DTO.mappers.BeverageMapper;
import be.hogent.eindproject.controller.DTO.mappers.OrderMapper;
import be.hogent.eindproject.model.model.Beverage;
import be.hogent.eindproject.model.model.OrderLine;
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
        OrderLine orderLine = new OrderLine(id, orderNumber, beverage, quantity, date);

        //when
        OrderLineDTO orderDTO = OrderMapper.mapToOrderDTO(orderLine);

        //then
        assertEquals(id, orderDTO.getId());
        assertEquals(orderNumber, orderDTO.getOrderNumber());
        assertEquals(BeverageMapper.mapToBeverageDTO(beverage), orderDTO.getBeverageDTO());
        assertEquals(quantity, orderDTO.getQuantity());
        assertEquals(date, orderDTO.getDate());
    }

    @Test
    void givenOrderDTO_whenMapToOrder_thenTheCorrectOrderIsProvided() {
        //given
        int id = 1;
        int orderNumber = 2;
        BeverageDTO beverageDTO = getBeverageDTO();
        int quantity = 3;
        LocalDate date = LocalDate.now();
        OrderLineDTO orderDTO = getOrderLinDTO(id, orderNumber, beverageDTO, quantity, date);

        //when
        OrderLine orderLine = OrderMapper.mapToOrder(orderDTO);

        //then
        assertEquals(id, orderLine.getId());
        assertEquals(orderNumber, orderLine.getOrderNumber());
        assertEquals(BeverageMapper.mapToBeverage(beverageDTO), orderLine.getBeverage());
        assertEquals(quantity, orderLine.getQuantity());
        assertEquals(date, orderLine.getDate());

    }

    private OrderLineDTO getOrderLinDTO(int id, int orderNumber, BeverageDTO beverageDTO, int quantity, LocalDate date) {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setId(id);
        orderLineDTO.setOrderNumber(orderNumber);
        orderLineDTO.setBeverageDTO(beverageDTO);
        orderLineDTO.setQuantity(quantity);
        orderLineDTO.setDate(date);

        return orderLineDTO;
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