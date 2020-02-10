package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.OrderDTO;
import be.hogent.eindproject.controller.DTO.TableDTO;
import be.hogent.eindproject.controller.DTO.mappers.TableMapper;
import be.hogent.eindproject.model.model.Order;
import be.hogent.eindproject.model.model.Table;

import java.util.HashMap;
import java.util.List;

public class TableController extends Controller {
    private HashMap<Integer, Table> tableList = new HashMap<>();

    public TableController(int numberOfTables) {
        super();
        createTableMap(numberOfTables);
    }

    public TableDTO getTableDTO(int tableNumber) {
        Table table = tableList.get(tableNumber);
        return TableMapper.mapToDTO(table);
    }

    public void addOrderToTable(int tableNumber, List<OrderDTO> orderDTOS) {

    }

    private void createTableMap(int numberOfTables) {
        for (int i = 0; i < numberOfTables; i++) {
            Table table = new Table(i);
            List<Order> openOrders = orderRepository.getOpenOrdersFor(table.getTableNumber());
            tableList.put(i, table);
        }
    }


}
