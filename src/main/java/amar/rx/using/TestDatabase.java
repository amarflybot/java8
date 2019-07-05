package amar.rx.using;

import amar.rx.helper.DataGenerator;
import amar.rx.jdbcInteraction.dto.Customer;
import org.apache.commons.io.FileUtils;
import rx.Observable;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 20/10/16.
 */
public class TestDatabase {

    public static void init() {
        final File databaseDirectory = new File("./rxJavaTest");
        System.out.println(databaseDirectory.getAbsolutePath());
        try {
            FileUtils.deleteDirectory(databaseDirectory);
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        final String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        final Connection c;

        try {
            DriverManager.getConnection("jdbc:derby:rxJavaTest;create=true");
            c = DriverManager.getConnection("jdbc:derby:rxJavaTest");
        } catch (final SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        Statement s = null;

        try {
            s = c.createStatement();
            String sql = "CREATE TABLE GREEK_ALPHABET (ID BIGINT, LETTER VARCHAR(255))";
            s.execute(sql);

            int id = 1;

            for (final String nextLetter : DataGenerator.generateGreekAlphabet()) {
                sql = "INSERT INTO GREEK_ALPHABET (ID, LETTER) VALUES (" + (id++) + ", '" + nextLetter + "')";
                s.execute(sql);
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (final SQLException e) {

                }
            }

            if (c != null) {
                try {
                    c.close();
                } catch (final SQLException e) {

                }
            }
        }
    }

    public static void init2() {
        final File databaseDirectory = new File("./pluralSightTest_DB");
        System.out.println(databaseDirectory.getAbsolutePath());
        try {
            FileUtils.deleteDirectory(databaseDirectory);
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        final String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (final InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        final Connection c;

        try {
            DriverManager.getConnection("jdbc:derby:pluralSightTest_DB;create=true");
            c = DriverManager.getConnection("jdbc:derby:pluralSightTest_DB");
        } catch (final SQLException e) {
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
            } catch (final SQLException e) {

            }
        }
    }

    public static ConnectionSubscription createSubscription() {
        return new ConnectionSubscription(createConnection("jdbc:derby:pluralSightTest_DB"));
    }

    public static Connection createConnection(final String url) {
        try {
            return DriverManager.getConnection(url);
        } catch (final SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Observable<String> selectGreekAlphabet(final ConnectionSubscription connectionSubscription) {
        try {
            final Statement s = connectionSubscription.getConnection().createStatement();
            connectionSubscription.registerResourceForClose(s);

            final ResultSet rs = s.executeQuery("SELECT LETTER FROM GREEK_ALPHABET");
            connectionSubscription.registerResourceForClose(rs);

            final ObservableList<String> returnList = new ObservableList<>();
            while (rs.next()) {
                returnList.add(rs.getString("LETTER"));
                try {
                    Thread.sleep(10);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }


            return returnList.getObservable();
        } catch (final SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Observable<Customer> selectAllCustomers(final ConnectionSubscription connectionSubscription) {
        try {
            final Statement s = connectionSubscription.getConnection().createStatement();
            connectionSubscription.registerResourceForClose(s);

            final ResultSet rs = s.executeQuery("SELECT ID, USERNAME FROM CUSTOMER");
            connectionSubscription.registerResourceForClose(rs);

            final List<Customer> returnList = new ArrayList<>();
            while (rs.next()) {
                final Customer customer = new Customer(rs.getLong("ID"), rs.getString("USERNAME"));
                returnList.add(customer);
            }

            return Observable.from(returnList);
        } catch (final SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static Observable<Customer> selectAllCustomers(final ConnectionSubscription connectionSubscription, final Long customerID) {
        try {
            final Statement s = connectionSubscription.getConnection().createStatement();
            connectionSubscription.registerResourceForClose(s);

            final ResultSet rs = s.executeQuery("SELECT ID, USERNAME FROM CUSTOMER WHERE ID = " + customerID);
            connectionSubscription.registerResourceForClose(rs);

            final List<Customer> returnList = new ArrayList<>();
            while (rs.next()) {
                final Customer customer = new Customer(rs.getLong("ID"), rs.getString("USERNAME"));
                returnList.add(customer);
            }

            return Observable.from(returnList);
        } catch (final SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
