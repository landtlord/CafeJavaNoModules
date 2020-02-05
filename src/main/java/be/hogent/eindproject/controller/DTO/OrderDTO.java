package be.hogent.eindproject.controller.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    private int id;
    private int orderNumber;
    private BeverageDTO beverageDTO;
    private int quantity;
    private LocalDate date;
    private WaiterDTO waiterDTO;
}
