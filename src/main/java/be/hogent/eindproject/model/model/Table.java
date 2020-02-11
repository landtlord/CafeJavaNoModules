package be.hogent.eindproject.model.model;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int tableNumber;

    private List<OrderLine> orderLines;

    public Table(int tableNumber, List<OrderLine> orderLines) {
        this.tableNumber = tableNumber;
        this.orderLines = new ArrayList<>();
        if (!(orderLines == null)) {
            this.orderLines = orderLines;
        }
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
