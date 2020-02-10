package be.hogent.eindproject.model.model;

import java.util.ArrayList;

public class Table {
    private final int tableNumber;

    private final ArrayList<Order> openOrdersList;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        openOrdersList = new ArrayList<>();
    }

    public boolean hasOrders() {
        return !openOrdersList.isEmpty();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public ArrayList<Order> getOpenOrders() {
        return openOrdersList;
    }
}
