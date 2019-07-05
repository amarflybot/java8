package amar.rx.jdbcInteraction.service;

import amar.rx.jdbcInteraction.TestDatabaseProcedures;
import amar.rx.jdbcInteraction.dto.Address;
import amar.rx.jdbcInteraction.dto.Customer;
import amar.rx.jdbcInteraction.dto.CustomerRelatedData;
import amar.rx.jdbcInteraction.dto.CustomerZipAccumulator;
import amar.rx.jdbcInteraction.dto.Product;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.sql.SQLException;

/**
 * Created by amarendra on 22/10/16.
 */
public class CustomerService {

    private final TestDatabaseProcedures procedures = new TestDatabaseProcedures();
    private final AddressService addressService = new AddressService();
    private final ProductService productService = new ProductService();

    public CustomerService() {
    }

    public Observable<Customer> fetchCustomer(long customerId) {
        try {
            return procedures.toSelectCustomersObservable(customerId);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Observable<Customer> fetchCustomersWithAddressesAndOwnedProducts(long customerId) {
        Observable<Customer> customerObservable = fetchCustomer(customerId);
        Observable<Address> addressObservable = addressService.fetchCustomerAddress(customerId);
        Observable<Product> productObservable = productService.fetchCustomerProduct(customerId);

        Observable<CustomerRelatedData> dataObservable = Observable.concat(
                customerObservable,
                addressObservable,
                productObservable)
                .observeOn(Schedulers.computation());

        Observable<Observable<CustomerRelatedData>> wrapperDataObservable =
                Observable.just(dataObservable);

        CustomerZipAccumulator zipAccumulator = new CustomerZipAccumulator();

        Observable<Customer> last = Observable
                .zip(wrapperDataObservable, zipAccumulator::collapseCustomerEvents)
                .last();

        return last;
    }
}
