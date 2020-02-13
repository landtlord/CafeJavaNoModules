package be.hogent.eindproject.model.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {
    private int ID;
    private List<OrderLine> orderLines;
    private int tableNumber;
    private Boolean payed;
    private LocalDate date;

    private Waiter waiter;

    public Order(int ID, List<OrderLine> orderLines, int tableNumber, Boolean payed, LocalDate date, Waiter waiter) {
        this.ID = ID;
        this.orderLines = orderLines;
        this.tableNumber = tableNumber;
        this.payed = payed;
        this.date = date;
        this.waiter = waiter;
    }

    public Order(int ID, int tableNumber, Boolean payed, Waiter waiter, LocalDate date) {
        this.ID = ID;
        this.tableNumber = tableNumber;
        this.payed = payed;
        this.waiter = waiter;
        this.date = date;
    }

    public Order(int ID, int tableNumber, boolean payed) {
        this.ID = ID;
        this.tableNumber = tableNumber;
        this.payed = payed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public int getTable() {
        return tableNumber;
    }

    public void setTable(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return ID == order.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
