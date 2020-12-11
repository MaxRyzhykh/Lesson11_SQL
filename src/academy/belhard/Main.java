package academy.belhard;

import java.sql.*;

public class Main {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/lesson11_db?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";


    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AddressConnector connector = new AddressConnector(connection);


        Address address1 = new Address(-1,"Minsk","Pushkina",21,0,261);
        Address address2 = new Address(-1,"Minsk","Rokossovskogo",100,3,1);
        Address address3 = new Address(-1,"Minsk","Lenina",1,0,56);
        Address address4 = new Address(-1,"Minsk","Mayakovskogo",65,1,87);
        Address address5 = new Address(-1,"Minsk","Traktornaya",78,2,93);
        connector.add(address1);
        connector.add(address2);
        connector.add(address3);
        connector.add(address4);
        connector.add(address5);
        System.out.println();

        for(Address a : connector.readAll()) {
            System.out.println(a);
        }

        Address ad_upd_4 = new Address(-1,"Zaslavl","Stochnaya",100,0,69);
        Address ad_upd_5 = new Address(-1,"Zaslavl","Peshaya",101,3,96);
        connector.update(4,ad_upd_4);
        connector.update(5,ad_upd_5);
        System.out.println();

        for(Address a : connector.readAll()) {
            System.out.println(a);
        }

        connector.delete(1);
        connector.delete(2);
        System.out.println();

        for(Address a : connector.readAll()) {
            System.out.println(a);
        }

    }
}
