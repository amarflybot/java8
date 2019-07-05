package amar.rx.jdbcInteraction;

import amar.rx.jdbcInteraction.dto.Customer;
import amar.rx.jdbcInteraction.service.CustomerService;
import amar.rx.using.TestDatabase;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by amarendra on 22/10/16.
 */
public class EdgeServiceSimulation {

    public static void main(final String[] args) throws InterruptedException {

        TestDatabase.init2();

        final CustomerService customerService = new CustomerService();
        final Observable<Customer> customerObservable = customerService.fetchCustomer(1);
        customerObservable.subscribe((customer) -> System.out.println(customer));

        final Observable<Customer> customerObservable1 = customerService.fetchCustomersWithAddressesAndOwnedProducts(1);
        customerObservable1.subscribe(customer -> customer.getAddresses().forEach(address -> System.out.println(address)));


        final Object waitMonitor = new Object();

        synchronized (waitMonitor) {

            final Observable<Customer> customerData = customerService.fetchCustomersWithAddressesAndOwnedProducts(3);

            customerData
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(
                            (customer) -> {
                                System.out.println("Customer -> " + customer);
                            }
                            ,
                            (t) -> {
                                t.printStackTrace();
                            }
                            ,
                            () -> {
                                synchronized (waitMonitor) {
                                    waitMonitor.notify();
                                }
                            }
                    );

            waitMonitor.wait();
        }
        System.exit(0);
    }
}
