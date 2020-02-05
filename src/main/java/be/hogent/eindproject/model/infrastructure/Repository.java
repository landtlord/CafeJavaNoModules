package be.hogent.eindproject.model.infrastructure;

import java.sql.*;

public abstract class Repository<T> {

    Connection getRepoConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "order", "AQWzsxedc1.");
    }

    public abstract T findByID(int ID);

    void cleanUpEnvironment(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();
    }
}
