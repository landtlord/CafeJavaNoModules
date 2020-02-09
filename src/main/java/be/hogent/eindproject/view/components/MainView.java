package be.hogent.eindproject.view.components;

import javafx.scene.layout.HBox;


public class MainView {

    private HBox mainView = new HBox();

    private TableView tableView;
    private OrderView orderView;


    public MainView() {
        tableView = new TableView(this);
        mainView.getChildren().add(tableView.getTableView());
    }

    public HBox getMainView() {
        return mainView;
    }


}
