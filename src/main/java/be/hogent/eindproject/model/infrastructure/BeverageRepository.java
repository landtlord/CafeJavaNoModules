package be.hogent.eindproject.model.infrastructure;

import be.hogent.eindproject.model.model.Beverage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeverageRepository extends Repository<Beverage> {

    @Override
    public Beverage findByID(int ID) {
        try {
            Connection connection = getRepoConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM beverages where beverageID = " + ID);
            resultSet.next();
            Beverage beverage = getBeverageFromResultset(resultSet);
            cleanUpEnvironment(connection, statement, resultSet);
            return beverage;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Beverage> getAllBeverages() {
        try {
            Connection connection = getRepoConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM beverages");
            List<Beverage> beverages = new ArrayList<>();
            while (resultSet.next()) {
                beverages.add(getBeverageFromResultset(resultSet));
            }
            cleanUpEnvironment(connection, statement, resultSet);
            return beverages;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private Beverage getBeverageFromResultset(ResultSet resultSet) throws SQLException {
        return new Beverage(
                resultSet.getInt("beverageID"),
                resultSet.getString("beverageName"),
                resultSet.getDouble("price"));
    }


}
