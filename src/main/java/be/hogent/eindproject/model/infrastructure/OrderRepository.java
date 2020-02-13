package be.hogent.eindproject.model.infrastructure;

import be.hogent.eindproject.model.model.Beverage;
import be.hogent.eindproject.model.model.Order;
import be.hogent.eindproject.model.model.OrderLine;
import be.hogent.eindproject.model.model.Waiter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends Repository<Order> {
    private BeverageRepository beverageRepository = new BeverageRepository();
    private WaiterRepository waiterRepository = new WaiterRepository();

    @Override
    public Order findByID(int ID) {
        try {
            Connection connection = getRepoConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where ID = " + ID);
            resultSet.next();
            Order order = getOrderFromResultset(resultSet);
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM orderlines where orderNumber = " + order.getID());
            order.setOrderLines(getOrderLinesFromResultSet(resultSet1));
            cleanUpEnvironment(connection, statement, resultSet);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getOpenOrderIDFor(int tableNumber) {
        try {
            Connection connection = getRepoConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM orders where table_number = " + tableNumber + " and payed = false");
            if (!resultSet.next()) return null;
            return resultSet.getInt("ID");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public Order getOpenOrderFor(int tableNumber) {
        try {
            Connection connection = getRepoConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where table_number = " + tableNumber + " and payed = true");
            if (!resultSet.next()) return null;
            return findByID(resultSet.getInt("ID"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Order getOrderFromResultset(ResultSet resultSet) throws SQLException {
        int ID = resultSet.getInt("ID");
        int tableNumber = resultSet.getInt("table_number");
        boolean payed = resultSet.getBoolean("payed");
        Waiter waiter = waiterRepository.findByID(resultSet.getInt("waiterID"));
        Date date = resultSet.getDate("date");
        LocalDate localDate = date.toLocalDate();

        return new Order(ID, tableNumber, payed, waiter, localDate);


    }

    private List<OrderLine> getOrderLinesFromResultSet(ResultSet resultSet) throws SQLException {
        List<OrderLine> orderLines = new ArrayList<>();
        while (resultSet.next()) {
            Beverage beverage = beverageRepository.findByID(resultSet.getInt("beverageID"));


            orderLines.add(new OrderLine(
                    resultSet.getInt("ID"),
                    resultSet.getInt("orderNumber"),
                    beverage,
                    resultSet.getInt("qty")));
        }
        return orderLines;
    }

}
