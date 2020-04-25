package be.hogent.eindproject.view.components.orderlist;

import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class OrderOnList {
    private HBox orderOnListBox;
    private OrderLineDTO orderLineDTO;
    private HBox counter;
    private TextField amount;
    private int amountToChange = 0;

    public OrderOnList(OrderLineDTO orderLineDTO) {
        orderOnListBox = new HBox();
        this.orderLineDTO = orderLineDTO;
        Label label = new Label(orderLineDTO.getBeverageDTO().getBeverageName());
        setCounter();
        orderOnListBox.getChildren().addAll(label, counter);
    }

    private void setCounter() {
        counter = new HBox();
        counter.setAlignment(Pos.CENTER_RIGHT);
        amount = new TextField(String.valueOf(orderLineDTO.getQuantity()));
        Button countUp = getButton(new Image(getClass().getResourceAsStream("/images/beverage-up.png")));
        countUp.setOnAction(e -> {
            amountToChange++;
            amount.setText(String.valueOf(orderLineDTO.getQuantity() + amountToChange));
        });
        amount.setMaxWidth(40);
        Button countDown = getButton(new Image(getClass().getResourceAsStream("/images/beverage-down.png")));
        countDown.setOnAction(e -> {
            if (amountToChange < orderLineDTO.getQuantity()) {
                amountToChange--;
                amount.setText(String.valueOf(orderLineDTO.getQuantity() + amountToChange));
            }
        });
        counter.getChildren().addAll(countUp, amount, countDown);
    }

    private Button getButton(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(15);
        imageView.setFitHeight(15);
        Button imageButton = new Button();
        imageButton.setGraphic(imageView);
        return imageButton;
    }

    OrderLineDTO getOrderLines() {
        orderLineDTO.setQuantity(amountToChange);
        return orderLineDTO;
    }

    HBox getOrderOnListBox() {
        return orderOnListBox;
    }
}
