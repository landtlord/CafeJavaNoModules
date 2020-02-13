package be.hogent.eindproject.model.model;

import java.util.Objects;

public class OrderLine {
    private final int id;
    private final int orderNumber;
    private final Beverage beverage;
    private final int quantity;


    public OrderLine(int id, int orderNumber, Beverage beverage, int quantity) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.beverage = beverage;
        this.quantity = quantity;

    }

    public int getId() {
        return this.id;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public Beverage getBeverage() {
        return this.beverage;
    }

    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return id == orderLine.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
