package be.hogent.eindproject.view.components.beveragelist;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderLineDTO;
import be.hogent.eindproject.controller.DTO.WaiterDTO;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BeverageOnList {
    BeverageDTO beverageDTO;
    HBox beverageOnListBox;
    HBox counter;
    TextField amount;
    int amountToOrder = 0;


    public BeverageOnList(BeverageDTO beverageDTO) {
        beverageOnListBox = new HBox();
        setCounter();
        this.beverageDTO = beverageDTO;
        Label label = new Label(beverageDTO.getBeverageName());
        beverageOnListBox.getChildren().addAll(label, counter);
    }

    private void setCounter() {
        counter = new HBox();
        counter.setAlignment(Pos.CENTER_RIGHT);
        amount = new TextField(String.valueOf(amountToOrder));
        Button countUp = getButton(new Image(getClass().getResourceAsStream("/images/beverage-up.png")));
        countUp.setOnAction(e -> {
            amountToOrder++;
            amount.setText(String.valueOf(amountToOrder));
        });
        amount.setMaxWidth(40);
        Button countDown = getButton(new Image(getClass().getResourceAsStream("/images/beverage-down.png")));
        countDown.setOnAction(e -> {
            if (amountToOrder > 0) {
                amountToOrder--;
                amount.setText(String.valueOf(amountToOrder));
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

    HBox getBeverageOnListBox() {
        return beverageOnListBox;
    }

    OrderLineDTO getOrderLines(WaiterDTO waiterDTO) {
        OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setWaiterDTO(waiterDTO);
        orderLineDTO.setBeverageDTO(beverageDTO);
        orderLineDTO.setQuantity(amountToOrder);
        return orderLineDTO;
    }

    public void reset() {
        amountToOrder = 0;
        amount.setText(String.valueOf(amountToOrder));
    }
}
