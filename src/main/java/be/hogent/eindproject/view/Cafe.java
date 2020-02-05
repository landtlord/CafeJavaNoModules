package be.hogent.eindproject.view;

import be.hogent.eindproject.controller.LogInController;
import be.hogent.eindproject.controller.WaiterController;
import be.hogent.eindproject.view.components.LoginPopup;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;

public class Cafe extends Application {

    private LogInController logInController = new LogInController();
    private WaiterController waiterController = new WaiterController();
    private VBox vBox = new VBox();

    public static void main(String[] args) {
        launch(args);
    }

    Boolean loggedIn = false;
    int loggedInWaiterID = -1;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome in Cafe Java");
        primaryStage.show();
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 1500, 1000));
        root.getChildren().add(vBox);
        checkIfLoggedIn();
    }

    private void setVBox() {
        vBox.getChildren().addAll(new Label("Welcome in Cafe Java"), getLogoutButton());
        Label waiterName = new Label(waiterController.getFullNameOfWaiterBy(loggedInWaiterID));
        vBox.getChildren().add(waiterName);
    }


    private Button getLogoutButton() {
        Button button = new Button("Log out");
        button.setOnAction(e -> {
            loggedIn = false;
            vBox.getChildren().clear();
            checkIfLoggedIn();
        });
        return button;
    }

    private void checkIfLoggedIn() {
        if (!loggedIn) {
            var login = new LoginPopup().getLoginPopup();
            Optional<Pair<String, String>> result = login.showAndWait();
            if (result.isPresent()) {
                try {
                    int waiterId = Integer.parseInt(result.get().getKey());
                    loggedIn = logInController.checkLogin(waiterId, result.get().getValue());
                    if (loggedIn) {
                        loggedInWaiterID = waiterId;
                        setVBox();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            checkIfLoggedIn();
        }
    }



}
