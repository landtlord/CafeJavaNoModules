package be.hogent.eindproject.controller.DTO;

public class TableDTO {
    private int tableNumber;
    private boolean orders;

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isOrders() {
        return orders;
    }

    public void setOrders(boolean orders) {
        this.orders = orders;
    }
}
