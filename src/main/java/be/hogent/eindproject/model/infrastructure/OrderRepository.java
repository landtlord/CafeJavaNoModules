package be.hogent.eindproject.model.infrastructure;

import be.hogent.eindproject.model.model.Beverage;
import be.hogent.eindproject.model.model.Order;
import be.hogent.eindproject.model.model.Waiter;

import java.sql.*;
import java.time.LocalDate;

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
            cleanUpEnvironment(connection, statement, resultSet);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Order getOrderFromResultset(ResultSet resultSet) throws SQLException {
        Beverage beverage = beverageRepository.findByID(resultSet.getInt("beverageID"));
        Waiter waiter = waiterRepository.findByID(resultSet.getInt("waiterID"));

        Date date = resultSet.getDate("date");
        LocalDate localDate = date.toLocalDate().plusDays(1);

        return new Order(
                resultSet.getInt("ID"),
                resultSet.getInt("orderNumber"),
                beverage,
                resultSet.getInt("qty"),
                localDate,
                waiter);
    }
}
