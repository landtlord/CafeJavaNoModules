package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.TableDTO;
import be.hogent.eindproject.controller.DTO.mappers.TableMapper;
import be.hogent.eindproject.model.infrastructure.OrderRepository;
import be.hogent.eindproject.model.model.Order;
import be.hogent.eindproject.model.model.Table;

import java.util.HashMap;
import java.util.List;

public class TableController {
    private HashMap<Integer, Table> tableList;
    private OrderRepository orderRepository = new OrderRepository();

    public TableController(int numberOfTables) {
        createTableMap(numberOfTables);
    }

    public TableDTO getTable(int tableNumber) {
        Table table = tableList.get(tableNumber);
        return TableMapper.mapToDTO(table);
    }

    private void createTableMap(int numberOfTables) {
        for (int i = 0; i < numberOfTables; i++) {
            Table table = new Table(i + 1);
            List<Order> openOrders = orderRepository.getOpenOrdersFor(table.getTableNumber());
            tableList.put(i + 1, table);
        }

    }


}
