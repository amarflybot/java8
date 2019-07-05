package amar.rx.jdbcInteraction.service;

import amar.rx.jdbcInteraction.TestDatabaseProcedures;
import amar.rx.jdbcInteraction.dto.Address;
import rx.Observable;

/**
 * Created by amarendra on 22/10/16.
 */
public class AddressService {

    private final TestDatabaseProcedures testDatabaseProcedures = new TestDatabaseProcedures();

    public Observable<Address> fetchCustomerAddress(final long customerId) {
        return testDatabaseProcedures.toSelectAddressObservable(customerId);
    }
}
