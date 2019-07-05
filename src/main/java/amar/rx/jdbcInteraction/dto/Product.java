package amar.rx.jdbcInteraction.dto;

/**
 * Created by amarendra on 22/10/16.
 */
public class Product extends CustomerRelatedData {

    private Long id;
    private String name;

    public Product(final long customerId, final Long id, final String name) {
        super(customerId);
        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
