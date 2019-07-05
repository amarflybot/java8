package amar.rx.jdbcInteraction.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by amarendra on 22/10/16.
 */
public class Customer extends CustomerRelatedData {

    private final List<Address> addresses = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private String username;

    public Customer(Long id, String username) {
        super(id);
        this.username = username;
    }

    public Customer() {
    }

    public String getUsername() {
        return username;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addresses);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", addresses=" + addresses +
                ", products=" + products +
                '}';
    }
}
