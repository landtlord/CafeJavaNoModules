package be.hogent.eindproject.view.components;

import javafx.scene.layout.GridPane;

public class TableView {
    private MainView mainView;
    private GridPane tableView = new GridPane();

    public TableView(MainView mainView) {
        this.mainView = mainView;
        fillWithTables();
    }

    private void fillWithTables() {
    }

    public GridPane getTableView() {
        return tableView;
    }
}
