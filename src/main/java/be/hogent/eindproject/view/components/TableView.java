package be.hogent.eindproject.view.components;

import be.hogent.eindproject.controller.DTO.TableDTO;
import be.hogent.eindproject.controller.LogInController;
import be.hogent.eindproject.controller.TableController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import static be.hogent.eindproject.view.Cafe.*;


public class TableView {
    private TableController tableController;
    private LogInController logInController;

    private MainView mainView;
    private GridPane tableView = new GridPane();

    public TableView(MainView mainView, TableController tableController, LogInController logInController) {
        this.tableController = tableController;
        this.logInController = logInController;
        this.mainView = mainView;
        fillWithTables();
    }


    private void fillWithTables() {
        //todo change calculation of rows and last row
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_TABLES / NUMBER_OF_COLUMNS; j++) {
                TableDTO tableDTO = tableController.getTableDTO(calculateTableNumber(i, j));
                Button imageView = getImageView(tableDTO);
                imageView.setOnAction(e -> mainView.switchToOrderView(tableDTO));
                tableView.add(imageView, i, j);
            }
        }
    }

    private Button getImageView(TableDTO tableDTO) {
        Image image = new Image(getClass().getResourceAsStream("/images/table-without-order.png"));
        if (tableDTO.hasOrders()) {
            if (tableDTO.getWaiterDTO().equals(logInController.getLoggedInWaiterDTO())) {
                image = new Image(getClass().getResourceAsStream("/images/table-with-order-from-me.png"));
            } else {
                image = new Image(getClass().getResourceAsStream("/images/table-with-order-from-other-waiter.png"));
            }
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(WIDTH * 5 / (6 * NUMBER_OF_COLUMNS) - 15);
        imageView.setFitHeight((HEIGHT / 4 - 8));
        Button imageButton = new Button();
        imageButton.setGraphic(imageView);
        return imageButton;
    }

    public GridPane getTableView() {
        return tableView;
    }

    public int calculateTableNumber(int i, int j) {
        return (j * NUMBER_OF_COLUMNS) + i;
    }
}
