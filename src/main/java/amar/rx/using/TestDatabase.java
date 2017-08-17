package amar.rx.using;

import amar.rx.helper.DataGenerator;
import amar.rx.jdbcInteraction.dto.Customer;
import org.apache.commons.io.FileUtils;
import rx.Observable;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 20/10/16.
 */
public class TestDatabase {

    public static void init() {
        File databaseDirectory = new File("./rxJavaTest");
        System.out.println(databaseDirectory.getAbsolutePath());
        try {
            FileUtils.deleteDirectory(databaseDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        Connection c;

        try {
            DriverManager.getConnection("jdbc:derby:rxJavaTest;create=true");
            c = DriverManager.getConnection("jdbc:derby:rxJavaTest");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        Statement s = null;

        try {
            s = c.createStatement();
            String sql = "CREATE TABLE GREEK_ALPHABET (ID BIGINT, LETTER VARCHAR(255))";
            s.execute(sql);

            int id = 1;

            for (String nextLetter : DataGenerator.generateGreekAlphabet()) {
                sql = "INSERT INTO GREEK_ALPHABET (ID, LETTER) VALUES (" + (id++) + ", '" + nextLetter + "')";
                s.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {

                }
            }

            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    public static void init2() {
        File databaseDirectory = new File("./pluralSightTest_DB");
        System.out.println(databaseDirectory.getAbsolutePath());
        try {
            FileUtils.deleteDirectory(databaseDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        Connection c;

        try {
            DriverManager.getConnection("jdbc:derby:pluralSightTest_DB;create=true");
            c = DriverManager.getConnection("jdbc:derby:pluralSightTest_DB");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        SqlHelper.execute(c, "CREATE TABLE CUSTOMER (ID BIGINT, USERNAME VARCHAR(20) )");
        SqlHelper.execute(c, "CREATE TABLE PRODUCT (ID BIGINT, NAME VARCHAR(40) )");
        SqlHelper.execute(c, "CREATE TABLE CUSTOMER_PRODUCT (ID BIGINT, CUSTOMERID BIGINT, PRODUCTID BIGINT )");
        SqlHelper.execute(c, "CREATE TABLE ADDRESS (ID BIGINT, CUSTOMERID BIGINT, ADDRESS1 VARCHAR(60) )");

        SqlHelper.execute(c, "INSERT INTO CUSTOMER (ID, USERNAME) VALUES(1, 'Amar' )");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER (ID, USERNAME) VALUES(2, 'Nagendra' )");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER (ID, USERNAME) VALUES(3, 'John' )");

        SqlHelper.execute(c, "INSERT INTO PRODUCT (ID, NAME) VALUES(1, 'Cricket Bat' )");
        SqlHelper.execute(c, "INSERT INTO PRODUCT (ID, NAME) VALUES(2, 'Base Ball Bat' )");
        SqlHelper.execute(c, "INSERT INTO PRODUCT (ID, NAME) VALUES(3, 'LG Television' )");
        SqlHelper.execute(c, "INSERT INTO PRODUCT (ID, NAME) VALUES(4, 'Sony Speakers' )");

        SqlHelper.execute(c, "INSERT INTO CUSTOMER_PRODUCT (ID, CUSTOMERID, PRODUCTID) VALUES(1, 1, 1)");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER_PRODUCT (ID, CUSTOMERID, PRODUCTID) VALUES(2, 1, 2)");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER_PRODUCT (ID, CUSTOMERID, PRODUCTID) VALUES(3, 2, 3)");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER_PRODUCT (ID, CUSTOMERID, PRODUCTID) VALUES(4, 3, 3)");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER_PRODUCT (ID, CUSTOMERID, PRODUCTID) VALUES(5, 3, 2)");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER_PRODUCT (ID, CUSTOMERID, PRODUCTID) VALUES(6, 3, 1)");
        SqlHelper.execute(c, "INSERT INTO CUSTOMER_PRODUCT (ID, CUSTOMERID, PRODUCTID) VALUES(7, 3, 4)");

        SqlHelper.execute(c, "INSERT INTO ADDRESS (ID, CUSTOMERID, ADDRESS1) VALUES(1, 1, 'Address1')");
        SqlHelper.execute(c, "INSERT INTO ADDRESS (ID, CUSTOMERID, ADDRESS1) VALUES(2, 2, 'Address2')");
        SqlHelper.execute(c, "INSERT INTO ADDRESS (ID, CUSTOMERID, ADDRESS1) VALUES(3, 3, 'Address3')");

        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {

            }
        }
    }

    public static ConnectionSubscription createSubscription(){
        return new ConnectionSubscription(createConnection("jdbc:derby:pluralSightTest_DB"));
    }

    public static Connection createConnection(String url) {
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Observable<String> selectGreekAlphabet(ConnectionSubscription connectionSubscription) {
        try {
            Statement s = connectionSubscription.getConnection().createStatement();
            connectionSubscription.registerResourceForClose(s);

            ResultSet rs = s.executeQuery("SELECT LETTER FROM GREEK_ALPHABET");
            connectionSubscription.registerResourceForClose(rs);

            ObservableList<String> returnList = new ObservableList<>();
            while(rs.next()) {
                returnList.add(rs.getString("LETTER"));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            return returnList.getObservable();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Observable<Customer> selectAllCustomers(ConnectionSubscription connectionSubscription) {
        try {
            Statement s = connectionSubscription.getConnection().createStatement();
            connectionSubscription.registerResourceForClose(s);

            ResultSet rs = s.executeQuery("SELECT ID, USERNAME FROM CUSTOMER");
            connectionSubscription.registerResourceForClose(rs);

            List<Customer> returnList = new ArrayList<>();
            while(rs.next()) {
                Customer customer = new Customer(rs.getLong("ID"), rs.getString("USERNAME"));
                returnList.add(customer);
            }

            return Observable.from(returnList);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Observable<Customer> selectAllCustomers(ConnectionSubscription connectionSubscription, Long customerID) {
        try {
            Statement s = connectionSubscription.getConnection().createStatement();
            connectionSubscription.registerResourceForClose(s);

            ResultSet rs = s.executeQuery("SELECT ID, USERNAME FROM CUSTOMER WHERE ID = " + customerID);
            connectionSubscription.registerResourceForClose(rs);

            List<Customer> returnList = new ArrayList<>();
            while(rs.next()) {
                Customer customer = new Customer(rs.getLong("ID"), rs.getString("USERNAME"));
                returnList.add(customer);
            }

            return Observable.from(returnList);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
