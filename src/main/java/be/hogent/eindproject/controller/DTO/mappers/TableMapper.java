package be.hogent.eindproject.controller.DTO.mappers;

import be.hogent.eindproject.controller.DTO.TableDTO;
import be.hogent.eindproject.model.model.Table;

public class TableMapper {
    public static TableDTO mapToDTO(Table table) {
        TableDTO tableDTO = new TableDTO();
        tableDTO.setTableNumber(table.getTableNumber());
        tableDTO.setOrders(table.hasOpenOrder());
        if (table.hasOpenOrder()) {
            tableDTO.setWaiterDTO(WaiterMapper.mapToWaiterDTO(table.getOrder().getWaiter()));
        }
        return tableDTO;
    }


}
