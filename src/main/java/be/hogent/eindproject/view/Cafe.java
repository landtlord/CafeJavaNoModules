package be.hogent.eindproject.view;

import be.hogent.eindproject.controller.LogInController;
import be.hogent.eindproject.controller.WaiterController;
import be.hogent.eindproject.view.components.LinkBox;
import be.hogent.eindproject.view.components.TableGrid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Cafe extends Application {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    public static final int NUMBER_OF_TABLES = 16;

    private LogInController logInController = new LogInController();
    private WaiterController waiterController = new WaiterController();
    private HBox hBox = new HBox();
    private Integer loggedInWaiterID = -1;

    private LinkBox linkBox;
    private TableGrid tableGrid;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome in Cafe Java");
        primaryStage.show();
        primaryStage.setScene(new Scene(hBox, WIDTH, HEIGHT));
        setHBox();
        linkBox.checkIfLoggedIn();
    }

    private void setHBox() {
        linkBox = new LinkBox(logInController);
        tableGrid = new TableGrid();
        hBox.getChildren().addAll(linkBox.getLinkBox(), tableGrid.getTableGrid());
    }

}
