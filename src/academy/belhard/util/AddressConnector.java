package academy.belhard.util;

import academy.belhard.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {
    private List<Address> addresses;
    private static final String SELECT_BY_ID = "SELECT * FROM addresses WHERE id = ?";
    private static final String SELECT = "SELECT * FROM addresses";
    private static  final  String INSERT = "INSERT INTO addresses (city, street, house_number, block, appartment) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE addresses " +
            "SET city = ?, street = ?, house_number = ?, block = ?, appartment = ? " +
            "WHERE id = ?";
    private static final  String DELETE = "DELETE FROM addresses WHERE id = ?";

    public AddressConnector(List<Address> addresses) {
        this.addresses = addresses;
    }

    public static Address byId(int id) {
        Connection connection = DBConnector.getConnection();

        Address result = null;

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            result = AddressUtil.toObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

// CRUD for Address object

     public void add(Address address) {
        Connection connection = DBConnector.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouseNumber());
            statement.setInt(4, address.getBlock());
            statement.setInt(5, address.getAppartment());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addList() {
        for(Address address : addresses){
            new AddressConnector(addresses).add(address);
        }
    }

    public static List<Address> readAll() {
        List<Address> res = new ArrayList<>();

        Connection connection = DBConnector.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Address address = AddressUtil.toObject(result);

                res.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static boolean update(Address address) {
        Connection connection = DBConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouseNumber());
            statement.setInt(4, address.getBlock());
            statement.setInt(5, address.getAppartment());
            statement.setInt(6, address.getId());

            int changed = statement.executeUpdate();

            return changed != 0;
        } catch (SQLException e) {
            System.out.println("Ошибка обновления");
        }

        return false;
    }

    public static void delete(int id) {
        Connection connection = DBConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка обновления");
        }
    }
}
