package be.hogent.eindproject.view.components;

import be.hogent.eindproject.controller.DTO.TableDTO;
import be.hogent.eindproject.controller.LogInController;
import be.hogent.eindproject.controller.OrderController;
import be.hogent.eindproject.controller.TableController;
import javafx.scene.layout.HBox;


public class MainView {
    private LogInController loginController;
    private TableController tableController;
    private OrderController orderController;

    private HBox mainView = new HBox();

    private TableView tableView;
    private OrderView orderView;


    public MainView(LogInController loginController, TableController tableController, OrderController orderController) {
        this.loginController = loginController;
        this.tableController = tableController;
        this.orderController = orderController;
        tableView = new TableView(this, tableController, loginController);
        orderView = new OrderView(this, orderController);
        mainView.getChildren().add(tableView.getTableView());
    }

    public HBox getMainView() {
        return mainView;
    }


    public void switchToOrderView(TableDTO tableDTO) {
        mainView.getChildren().clear();
        mainView.getChildren().add(orderView.getOrderView(tableDTO.getTableNumber()));
    }

    public void switchToTableView() {
        mainView.getChildren().clear();
        tableView = new TableView(this, tableController, loginController);
        mainView.getChildren().add(tableView.getTableView());
    }
}
