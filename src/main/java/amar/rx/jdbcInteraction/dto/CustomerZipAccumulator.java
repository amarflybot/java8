package amar.rx.jdbcInteraction.dto;

/**
 * Created by amarendra on 23/10/16.
 */
public class CustomerZipAccumulator {

    private Customer customer;

    public void addAddress(final Address address) {
        customer.addAddress(address);
    }

    public void addOwnedProduct(final Product ownedProduct) {
        customer.addProducts(ownedProduct);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Customer collapseCustomerEvents(final Object[] events) {

        for (final Object event : events) {

            final CustomerRelatedData nextData = (CustomerRelatedData) event;

            if (nextData instanceof Customer) {
                customer = (Customer) nextData;
            }

            if (nextData instanceof Address) {
                customer.addAddress((Address) nextData);
            } else if (nextData instanceof Product) {
                customer.addProducts((Product) nextData);
            }
        }

        return customer;
    }
}
