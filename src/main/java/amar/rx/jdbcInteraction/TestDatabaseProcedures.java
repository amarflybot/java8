package amar.rx.jdbcInteraction;

import amar.rx.jdbcInteraction.dto.Address;
import amar.rx.jdbcInteraction.dto.Customer;
import amar.rx.jdbcInteraction.dto.Product;
import amar.rx.using.SqlHelper;
import amar.rx.using.TestDatabase;
import rx.Observable;

import java.sql.SQLException;

/**
 * Created by amarendra on 22/10/16.
 */
public class TestDatabaseProcedures {


    public Observable<Customer> toSelectCustomersObservable() throws SQLException {
        return Observable.using(
                () -> TestDatabase.createSubscription(),
                (connectionSubscription) -> /*TestDatabase.selectAllCustomers(connectionSubscription)*/
                {
                    try {
                        return SqlHelper.executeQuery(connectionSubscription, "SELECT ID, USERNAME FROM CUSTOMER",
                                (resultSet) -> new Customer(resultSet.getLong("ID"), resultSet.getString("USERNAME")));

                    } catch (SQLException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
                , (connectionSubscription) ->
                        connectionSubscription.unsubscribe());
    }

    public Observable<Customer> toSelectCustomersObservable(Long customerID) throws SQLException {
        return Observable.using(
                () -> TestDatabase.createSubscription(),
                (connectionSubscription) -> /*TestDatabase.selectAllCustomers(connectionSubscription, customerID)*/
                {
                    try {
                        return SqlHelper.executeQuery(connectionSubscription, "SELECT ID, USERNAME FROM CUSTOMER WHERE ID = " + customerID,
                                (resultSet) -> new Customer(resultSet.getLong("ID"), resultSet.getString("USERNAME")));

                    } catch (SQLException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
                , (connectionSubscription) ->
                        connectionSubscription.unsubscribe());
    }


    public Observable<Address> toSelectAddressObservable(long customerId) {
        return Observable.using(
                () -> TestDatabase.createSubscription(),
                (connectionSubscription) -> /*TestDatabase.selectAllCustomers(connectionSubscription, customerID)*/
                {
                    try {
                        return SqlHelper.executeQuery(connectionSubscription, "SELECT ID, ADDRESS1 FROM ADDRESS WHERE CUSTOMERID = " + customerId,
                                (resultSet) -> new Address(resultSet.getLong("ID"), resultSet.getString("ADDRESS1")));

                    } catch (SQLException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
                , (connectionSubscription) ->
                        connectionSubscription.unsubscribe());
    }

    public Observable<Product> toSelectProductObservable(long customerId) {
        return Observable.using(
                () -> TestDatabase.createSubscription(),
                (connectionSubscription) -> /*TestDatabase.selectAllCustomers(connectionSubscription, customerID)*/
                {
                    try {
                        return SqlHelper.executeQuery(connectionSubscription, "SELECT CUSTOMERID, PRODUCTID, NAME FROM CUSTOMER_PRODUCT CP " +
                                        "JOIN PRODUCT P ON P.ID = CP.PRODUCTID  WHERE CUSTOMERID = " + customerId,
                                (resultSet) -> new Product(resultSet.getLong("CUSTOMERID"), resultSet.getLong("PRODUCTID"), resultSet.getString("NAME")));

                    } catch (SQLException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
                , (connectionSubscription) ->
                        connectionSubscription.unsubscribe());
    }
}
