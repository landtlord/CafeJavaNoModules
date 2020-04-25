package be.hogent.eindproject.view.components.orderlist;

import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

import java.util.List;
import java.util.stream.Collectors;

public class OrderList {
    private List<OrderOnList> orderOnLists;

    public OrderList(List<OrderLineDTO> orderLineDTOS) {
        orderOnLists = orderLineDTOS.stream()
                .map(OrderOnList::new)
                .collect(Collectors.toList());
    }

    public ObservableList<HBox> getOrderInList() {
        return FXCollections.observableArrayList(orderOnLists.stream()
                .map(OrderOnList::getOrderOnListBox)
                .collect(Collectors.toList()));
    }

    public List<OrderLineDTO> getCorrections() {
        return orderOnLists.stream()
                .map(OrderOnList::getOrderLines)
                .collect(Collectors.toList());
    }
}
