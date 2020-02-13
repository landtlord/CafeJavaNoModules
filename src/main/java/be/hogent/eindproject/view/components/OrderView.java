package be.hogent.eindproject.view.components;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.controller.OrderController;
import be.hogent.eindproject.view.Cafe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.stream.Collectors;

public class OrderView {
    private final OrderController orderController;

    private MainView mainView;
    private HBox orderView = new HBox();

    public OrderView(MainView mainView, OrderController orderController) {
        this.orderController = orderController;
        this.mainView = mainView;
    }

    public void setTable(int tableNumber) {
        orderView.getChildren().clear();
        orderView.getChildren().add(new Text("Current table " + tableNumber));
    }

    public Node getOrderView(int tableNumber) {
        setTable(tableNumber);
        orderView.getChildren().clear();
        Button returnToTableView = new Button("return");
        returnToTableView.setOnAction(e -> mainView.switchToTableView());
        orderView.getChildren().addAll(getBeverageListView(), getOrderListView(tableNumber));
        return orderView;
    }

    private Node getOrderListView(int tableNumber) {
        VBox orderListView = new VBox();

        orderListView.getChildren().addAll(getOrderList(tableNumber), getButtons());
        return orderListView;
    }

    private Node getButtons() {
        GridPane buttons = new GridPane();
        Button add = new Button("add");
        buttons.add(add, 0, 0);
        Button correct = new Button("correct");
        buttons.add(correct, 1, 0);
        Button pay = new Button("pay");
        buttons.add(pay, 0, 1);
        Button cancel = new Button("cancel");
        buttons.add(cancel, 1, 1);
        cancel.setOnAction(e -> mainView.switchToTableView());
        return buttons;
    }

    private Node getOrderList(int tableNumber) {
        ListView<String> orderList = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                orderController.getOrdersFor(tableNumber)
                        .stream()
                        .map(OrderLineDTO::getBeverageDTO)
                        .map(BeverageDTO::getBeverageName)
                        .collect(Collectors.toList()));
        orderList.setItems(items);
        orderList.setMinWidth(Cafe.WIDTH * 5 / (6 * 2));
        orderList.setMaxHeight(Cafe.HEIGHT * 75 / 100);
        return orderList;
    }

    private Node getBeverageListView() {
        ListView<String> beverageDTOs = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                orderController.getBeverageDTOs()
                        .stream()
                        .map(BeverageDTO::getBeverageName)
                        .collect(Collectors.toList()));
        beverageDTOs.setItems(items);
        beverageDTOs.setMinWidth(Cafe.WIDTH * 5 / (6 * 2));
        return beverageDTOs;
    }


}
