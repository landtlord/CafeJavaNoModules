package be.hogent.eindproject.view;

import be.hogent.eindproject.controller.LogInController;
import be.hogent.eindproject.controller.OrderController;
import be.hogent.eindproject.controller.TableController;
import be.hogent.eindproject.view.components.LinkBox;
import be.hogent.eindproject.view.components.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Cafe extends Application {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    public static final int NUMBER_OF_TABLES = 16;
    public static final int NUMBER_OF_COLUMNS = 4;

    private LogInController logInController = new LogInController();
    private TableController tableController = new TableController(16);
    private OrderController orderController = new OrderController();

    private HBox view = new HBox();

    private LinkBox linkBox;
    private MainView mainView;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome in Cafe Java");
        primaryStage.show();
        primaryStage.setScene(new Scene(view, WIDTH, HEIGHT));
        setView();
        linkBox.checkIfLoggedIn();
    }

    private void setView() {
        mainView = new MainView(logInController, tableController, orderController);
        linkBox = new LinkBox(logInController, mainView);
        view.getChildren().addAll(linkBox.getLinkBox(), mainView.getMainView());
    }

}
