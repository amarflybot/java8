package amar.rx.jdbcInteraction.dto;

/**
 * Created by amarendra on 23/10/16.
 */
public class CustomerZipAccumulator {

    private Customer customer;

    public void addAddress(Address address) {
        customer.addAddress(address);
    }

    public void addOwnedProduct(Product ownedProduct) {
        customer.addProducts(ownedProduct);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Customer collapseCustomerEvents(Object[] events) {

        for(Object event: events) {

            CustomerRelatedData nextData = (CustomerRelatedData) event;

            if(nextData instanceof Customer) {
                customer = (Customer) nextData;
            }

            if(nextData instanceof Address) {
                customer.addAddress((Address) nextData);
            }
            else if (nextData instanceof  Product) {
                customer.addProducts((Product) nextData);
            }
        }

        return customer;
    }
}
