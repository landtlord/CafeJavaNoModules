package be.hogent.eindproject.view.components;


import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class LoginPopup {
    private Dialog<Pair<String, String>> dialog;

    public LoginPopup() {
        this.dialog = createLoginPopup();
    }

    public Dialog<Pair<String, String>> getLoginPopup() {
        return dialog;
    }

    private Dialog<Pair<String, String>> createLoginPopup() {
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

        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        loginScreen.getChildren().addAll(waiterIdLabel, waiterIdText, waiterPassword, waiterPasswordField);

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
