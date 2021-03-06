package be.hogent.eindproject.controller.DTO;

import java.util.Objects;

public class OrderLineDTO {
    private int id;
    private int orderNumber;
    private BeverageDTO beverageDTO;
    private int quantity;
    private WaiterDTO waiterDTO;

    public OrderLineDTO() {
    }

    public int getId() {
        return this.id;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public BeverageDTO getBeverageDTO() {
        return this.beverageDTO;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public WaiterDTO getWaiterDTO() {
        return this.waiterDTO;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setBeverageDTO(BeverageDTO beverageDTO) {
        this.beverageDTO = beverageDTO;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWaiterDTO(WaiterDTO waiterDTO) {
        this.waiterDTO = waiterDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineDTO orderDTO = (OrderLineDTO) o;
        return id == orderDTO.id &&
                orderNumber == orderDTO.orderNumber &&
                quantity == orderDTO.quantity &&
                Objects.equals(beverageDTO, orderDTO.beverageDTO) &&
                Objects.equals(waiterDTO, orderDTO.waiterDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, beverageDTO, quantity, waiterDTO);
    }

    @Override
    public String toString() {
        return "OrderLineDTO{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", beverageDTO=" + beverageDTO +
                ", quantity=" + quantity +
                ", waiterDTO=" + waiterDTO +
                '}';
    }
}
