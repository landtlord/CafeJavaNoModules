package be.hogent.eindproject.model.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class Order {
    private final int id;
    private final int orderNumber;
    private final Beverage beverage;
    private final int quantity;
    private final LocalDate date;
    private final Waiter waiter;

    public Order(int id, int orderNumber, Beverage beverage, int quantity, LocalDate date, Waiter waiter) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.beverage = beverage;
        this.quantity = quantity;
        this.date = date;
        this.waiter = waiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
