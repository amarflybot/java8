package amar.rx.jdbcInteraction.dto;

/**
 * Created by amarendra on 22/10/16.
 */
public class Address extends CustomerRelatedData{

    private Long id;
    private String address1;

    public Address(Long id, long customerID, String address1) {
        super(customerID);
        this.id = id;
        this.address1 = address1;
    }

    public Address() {
    }

    public Address(long id, String address1) {
        this.id = id;
        this.address1 = address1;
    }

    public Long getId() {
        return id;
    }

    public String getAddress1() {
        return address1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address1='" + address1 + '\'' +
                '}';
    }
}
