package amar.rx.jdbcInteraction.dto;

/**
 * Created by amarendra on 23/10/16.
 */
public class CustomerRelatedData {

    private long customerId;

    public CustomerRelatedData() {
    }

    public CustomerRelatedData(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "CustomerRelatedData{" +
                "customerId=" + customerId +
                '}';
    }
}
