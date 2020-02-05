package be.hogent.eindproject.model.infrastructure;

import be.hogent.eindproject.model.model.Waiter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WaiterRepository extends Repository<Waiter> {
    @Override
    public Waiter findByID(int ID) {
        try {
            Connection connection = getRepoConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM waiters where waiterID = " + ID);
            resultSet.next();
            Waiter waiter = getWaiterFromResultset(resultSet);
            cleanUpEnvironment(connection, statement, resultSet);
            return waiter;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Waiter getWaiterFromResultset(ResultSet resultSet) throws SQLException {
        return new Waiter(
                resultSet.getInt("waiterID"),
                resultSet.getString("lastName"),
                resultSet.getString("firstName"),
                resultSet.getString("password")
        );
    }
}
