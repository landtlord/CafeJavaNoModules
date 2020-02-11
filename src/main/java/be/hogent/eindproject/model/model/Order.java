package be.hogent.eindproject.model.model;

import java.util.List;

public class Order {
    private int ID;
    private List<OrderLine> orderLines;
    private int tableNumber;
    private Boolean payed;

    public Order(int ID, int tableNumber, boolean payed) {
        this.ID = ID;
        this.tableNumber = tableNumber;
        this.payed = payed;
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
}
