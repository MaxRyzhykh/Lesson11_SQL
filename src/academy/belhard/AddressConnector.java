package academy.belhard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private Connection connection;

    private static final String REQUEST = "SELECT * FROM addresses";
    private static final String ADD = "INSERT INTO addresses(city,street,house_number,corps_number,apartment_number) VALUES (?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM addresses WHERE id = ?";
    private static final String UPDATE = "UPDATE addresses SET city = ?, street = ?, house_number = ?, corps_number = ?, apartment_number = ? WHERE id = ?";

    public AddressConnector(Connection connection) {
        this.connection = connection;
    }

    public void add(Address address) {
        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouse_number());
            statement.setInt(4, address.getCorps_number());
            statement.setInt(5, address.getApartment_number());

            int res = statement.executeUpdate();

            System.out.println("added rows: " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Address> readAll() {
        List<Address> res = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String city = result.getString("city");
                String street = result.getString("street");
                int house_number = result.getInt("house_number");
                int corps_number = result.getInt("corps_number");
                int apartment_number = result.getInt("apartment_number");

                Address a = new Address(id, city, street, house_number, corps_number, apartment_number);

                res.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }


public void delete(int id_numb) {
    try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
        statement.setInt(1,id_numb);

        int res = statement.executeUpdate();

        System.out.println("deleted rows: " + res);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void update(int id, Address address) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(6, id);
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouse_number());
            statement.setInt(4, address.getCorps_number());
            statement.setInt(5, address.getApartment_number());

            int res = statement.executeUpdate();

            System.out.println("updated rows: " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
