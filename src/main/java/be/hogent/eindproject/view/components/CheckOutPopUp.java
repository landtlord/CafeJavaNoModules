package be.hogent.eindproject.view.components;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.view.Cafe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class CheckOutPopUp {
    private Alert checkOutPopUp;
    private List<OrderLineDTO> orderLineDTOList;

    public CheckOutPopUp(List<OrderLineDTO> orderLineDTOList) {
        this.orderLineDTOList = orderLineDTOList;
        this.checkOutPopUp = createCheckOutPopup();
    }

    public Alert getCheckOutPopUp() {
        return checkOutPopUp;
    }

    private Alert createCheckOutPopup() {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Rekening");

        ListView<String> orderList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                orderLineDTOList
                        .stream()
                        .map(OrderLineDTO::getBeverageDTO)
                        .map(BeverageDTO::getBeverageName)
                        .collect(Collectors.toList()));
        orderList.setItems(items);
        orderList.setMinWidth(Cafe.WIDTH * 5 / (6 * 2));
        orderList.setMaxHeight(Cafe.HEIGHT * 75 / 100);

        ((Stage) dialog.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
        dialog.getDialogPane().setContent(orderList);

        return dialog;
    }
}
