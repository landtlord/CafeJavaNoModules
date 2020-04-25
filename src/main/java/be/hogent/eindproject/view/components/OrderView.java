package be.hogent.eindproject.view.components;

import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.controller.LogInController;
import be.hogent.eindproject.controller.OrderController;
import be.hogent.eindproject.view.Cafe;
import be.hogent.eindproject.view.components.beveragelist.BeverageList;
import be.hogent.eindproject.view.components.orderlist.OrderList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class OrderView {
    private final OrderController orderController;
    private LogInController loginController;

    private MainView mainView;
    private HBox orderView = new HBox();
    private BeverageList beverageList;
    private OrderList orderInList;


    public OrderView(MainView mainView, OrderController orderController, LogInController loginController) {
        this.orderController = orderController;
        this.loginController = loginController;
        this.mainView = mainView;
        beverageList = new BeverageList(orderController.getBeverageDTOs());
        orderInList = null;
    }

    public Node getOrderView(int tableNumber) {
        orderView.getChildren().clear();
        orderView.getChildren().addAll(getBeverageListView(), getOrderListView(tableNumber));
        return orderView;
    }

    private Node getOrderListView(int tableNumber) {
        VBox orderListView = new VBox();
        orderListView.getChildren().addAll(getOrderList(tableNumber), getButtons(tableNumber));
        return orderListView;
    }

    private Node getButtons(int tableNumber) {
        GridPane buttons = new GridPane();
        Button addButton = new Button("add");
        buttons.add(addButton, 0, 0);
        addButton.setOnAction(e -> {
            List<OrderLineDTO> orderLineDTOS = beverageList.getOrderLineDTOs(loginController.getLoggedInWaiterDTO());
            orderController.addOrderLinesToOrder(orderLineDTOS, tableNumber, loginController.getLoggedInWaiterDTO());
            beverageList.reset();
            mainView.switchToTableView();
        });
        Button correctButton = new Button("correct");
        buttons.add(correctButton, 1, 0);
        correctButton.setOnAction(e -> {
            List<OrderLineDTO> orderLineDTOS = orderInList.getCorrections();
            orderController.addOrderLinesToOrder(orderLineDTOS, tableNumber, loginController.getLoggedInWaiterDTO());
            mainView.switchToTableView();
        });
        Button payButton = new Button("pay");
        payButton.setOnAction(e -> {
            new CheckOutPopUp(orderController.getOrderLinesFor(tableNumber)).getCheckOutPopUp().showAndWait();
            orderController.payOrder(tableNumber);
            mainView.switchToTableView(tableNumber);
        });
        buttons.add(payButton, 0, 1);
        Button cancel = new Button("cancel");
        buttons.add(cancel, 1, 1);
        cancel.setOnAction(e -> mainView.switchToTableView());
        return buttons;
    }

    private Node getOrderList(int tableNumber) {
        ListView<HBox> orderList = new ListView<>();
        orderInList = new OrderList(orderController.getOrderLinesFor(tableNumber));
        ObservableList<HBox> orderInList = this.orderInList.getOrderInList();
        orderList.setItems(orderInList);
        orderList.setMinWidth(Cafe.WIDTH * 5 / (6 * 2));
        orderList.setMaxHeight(Cafe.HEIGHT * 75 / 100);
        return orderList;
    }

    private Node getBeverageListView() {
        ListView<HBox> beverageDTOs = new ListView<>();
        beverageDTOs.setItems(beverageList.getBeverageDTOList());
        beverageDTOs.setMinWidth(Cafe.WIDTH * 5 / (6 * 2));
        return beverageDTOs;
    }
}
