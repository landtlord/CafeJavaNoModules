package be.hogent.eindproject.view;

import be.hogent.eindproject.controller.LogInController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;

public class Cafe extends Application {

    private LogInController logInController = new LogInController();

    public static void main(String[] args) {
        launch(args);
    }

    Boolean loggedIn = false;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome in Cafe Java");


        StackPane root = new StackPane();
        root.getChildren().addAll(new Label("Welcome in Cafe Java"), getLogoutButton());
        primaryStage.setScene(new Scene(root, 1500, 1000));
        primaryStage.show();
        checkIfLoggedIn();
    }

    private Button getLogoutButton() {
        Button button = new Button("Log out");
        button.setOnAction(e -> {
            loggedIn = false;
            checkIfLoggedIn();
        });
        return button;
    }

    private void checkIfLoggedIn() {
        if (!loggedIn) {
            var login = getLoginPopup();
            Optional<Pair<String, String>> result = login.showAndWait();
            if (result.isPresent()) {
                try {
                    int waiterId = Integer.parseInt(result.get().getKey());
                    loggedIn = logInController.checkLogin(waiterId, result.get().getValue());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            checkIfLoggedIn();
        }
    }

    private Dialog<Pair<String, String>> getLoginPopup() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");

        GridPane loginScreen = new GridPane();
        loginScreen.setPadding(new Insets(10, 10, 10, 10));
        loginScreen.setHgap(10);
        loginScreen.setVgap(8);

        Label waiterIdLabel = new Label("personeelsnummer");
        GridPane.setConstraints(waiterIdLabel, 0, 0);

        TextField waiterIdText = new TextField();
        GridPane.setConstraints(waiterIdText, 1, 0);

        Label waiterPassword = new Label("paswoord");
        GridPane.setConstraints(waiterPassword, 0, 1);

        PasswordField waiterPasswordField = new PasswordField();
        GridPane.setConstraints(waiterPasswordField, 1, 1);

        Label isLoggedIn = new Label(loggedIn.toString());
        GridPane.setConstraints(isLoggedIn, 0, 2);

        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        loginScreen.getChildren().addAll(waiterIdLabel, waiterIdText, waiterPassword, waiterPasswordField, isLoggedIn);

        ((Stage) dialog.getDialogPane().getScene().getWindow()).setAlwaysOnTop(true);
        dialog.getDialogPane().setContent(loginScreen);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(waiterIdText.getText(), waiterPasswordField.getText());
            }
            return null;
        });

        return dialog;
    }

}
