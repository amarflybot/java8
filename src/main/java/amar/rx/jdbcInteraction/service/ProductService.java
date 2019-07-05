package amar.rx.jdbcInteraction.service;

import amar.rx.jdbcInteraction.TestDatabaseProcedures;
import amar.rx.jdbcInteraction.dto.Product;
import rx.Observable;

/**
 * Created by amarendra on 22/10/16.
 */
public class ProductService {

    private final TestDatabaseProcedures testDatabaseProcedures = new TestDatabaseProcedures();

    public Observable<Product> fetchCustomerProduct(final long customerId) {
        return testDatabaseProcedures.toSelectProductObservable(customerId);
    }
}
