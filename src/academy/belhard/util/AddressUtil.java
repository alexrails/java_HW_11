package academy.belhard.util;

import academy.belhard.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressUtil {
    public static Address toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        int houseNumber = resultSet.getInt("house_number");
        int block = resultSet.getInt("block");
        int appartment = resultSet.getInt("appartment");

        return new Address(id, city, street, houseNumber, block, appartment);
    }
}
