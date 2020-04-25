package be.hogent.eindproject.view.components.beveragelist;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.controller.DTO.WaiterDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

import java.util.List;
import java.util.stream.Collectors;

public class BeverageList {
    private List<BeverageOnList> beverageOnLists;

    public BeverageList(List<BeverageDTO> beverageDTOS) {
        beverageOnLists = beverageDTOS.stream()
                .map(BeverageOnList::new)
                .collect(Collectors.toList());
    }

    public ObservableList<HBox> getBeverageDTOList() {
        return FXCollections.observableArrayList(beverageOnLists.stream()
                .map(BeverageOnList::getBeverageOnListBox)
                .collect(Collectors.toList()));
    }

    public List<OrderLineDTO> getOrderLineDTOs(WaiterDTO waiterDTO) {
        return beverageOnLists.stream()
                .map(beverageOnList -> beverageOnList.getOrderLines(waiterDTO))
                .collect(Collectors.toList());
    }

    public void reset() {
        beverageOnLists.stream().forEach(BeverageOnList::reset);
    }
}
