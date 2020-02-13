package be.hogent.eindproject.model.model;

public class Table {
    private final int tableNumber;
    private Order order;

    public Table(int tableNumber, Order order) {
        this.tableNumber = tableNumber;
        setOrderOnTable(order);
    }

    private void setOrderOnTable(Order order) {
        this.order = order;
        if (this.hasOpenOrder()) {

        }
    }

    public Integer getOrderID() {
        return order.getID();
    }

    public int getTableNumber() {
        return tableNumber;
    }


    public Order getOrder() {
        return order;
    }

    public boolean hasOpenOrder() {
        return order != null;
    }
}
