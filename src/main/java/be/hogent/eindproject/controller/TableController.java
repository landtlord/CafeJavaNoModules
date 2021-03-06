package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.TableDTO;
import be.hogent.eindproject.controller.DTO.mappers.TableMapper;
import be.hogent.eindproject.model.model.Order;
import be.hogent.eindproject.model.model.Table;

import java.util.HashMap;

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

    private void createTableMap(int numberOfTables) {
        for (int i = 0; i < numberOfTables; i++) {
            Order order = orderRepository.getOpenOrderFor(i);
            Table table;
            if (order == null) {
                table = new Table(i, null);
            } else {
                table = new Table(i, order);
            }
            tableList.put(i, table);
        }
    }

    public void tablePayed(int tableNumber) {
        tableList.get(tableNumber).payOrder();
    }
}
