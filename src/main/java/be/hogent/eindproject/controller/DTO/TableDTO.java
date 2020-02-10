package be.hogent.eindproject.controller.DTO;

public class TableDTO {
    private int tableNumber;
    private boolean orders;
    private WaiterDTO waiterDTO;

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean hasOrders() {
        return orders;
    }

    public void setOrders(boolean orders) {
        this.orders = orders;
    }

    public WaiterDTO getWaiterDTO() {
        return waiterDTO;
    }

    public void setWaiterDTO(WaiterDTO waiterDTO) {
        this.waiterDTO = waiterDTO;
    }
}
