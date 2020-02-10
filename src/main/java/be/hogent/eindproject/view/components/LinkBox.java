package be.hogent.eindproject.view.components;

import be.hogent.eindproject.controller.DTO.WaiterDTO;
import be.hogent.eindproject.controller.LogInController;
import be.hogent.eindproject.view.Cafe;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.util.Optional;

public class LinkBox {
    private MainView mainView;
    private VBox linkBox;
    private LogInController logInController;
    private Text loggedInUser;

    public LinkBox(LogInController logInController, MainView mainView) {
        this.logInController = logInController;
        this.mainView = mainView;
        setLoggedInUser();
        setLinkBox();

    }

    private void setLoggedInUser() {
        loggedInUser = new Text();
        refreshLoggedInUser();
    }

    private String getNameFromWaiterDTO(WaiterDTO loggedInWaiterDTO) {
        return loggedInWaiterDTO.getFirstName() + " " + loggedInWaiterDTO.getLastName();
    }

    private void setLinkBox() {
        linkBox = new VBox(loggedInUser, getLogoutButton());
        linkBox.setMinSize((double) Cafe.WIDTH / 6, Cafe.HEIGHT);
        linkBox.setBackground((new Background(new BackgroundFill(Color.rgb(100, 100, 100), CornerRadii.EMPTY, Insets.EMPTY))));
    }

    public VBox getLinkBox() {
        return linkBox;
    }

    private Button getLogoutButton() {
        Button button = new Button("Log out");
        button.setOnAction(e -> {
            logInController.logOut();
            refreshLoggedInUser();
            mainView.switchToTableView();
            checkIfLoggedIn();
        });
        return button;
    }

    public void checkIfLoggedIn() {
        while (!logInController.isLoggedIn()) {
            var login = new LoginPopup().getLoginPopup();
            Optional<Pair<String, String>> result = login.showAndWait();
            if (result.isPresent()) {
                try {
                    int filledInWaiterId = Integer.parseInt(result.get().getKey());
                    String filledInPassword = result.get().getValue();
                    logInController.checkLogin(filledInWaiterId, filledInPassword);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        refreshLoggedInUser();
    }

    private void refreshLoggedInUser() {
        WaiterDTO loggedInWaiterDTO = logInController.getLoggedInWaiterDTO();
        if (loggedInWaiterDTO != null) {
            loggedInUser.setText(getNameFromWaiterDTO(loggedInWaiterDTO));
        } else {
            loggedInUser.setText("Log in...");
        }
    }


}
