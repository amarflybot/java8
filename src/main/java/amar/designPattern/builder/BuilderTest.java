package amar.designPattern.builder;

/**
 * Created by amarendra on 26/02/16.
 */
public class BuilderTest {

    public static void main(String[] args) {
        PersonBuilder person = new PersonBuilder(2);
        person.addAddress("Add").addHeight(123).addName("Amar");
        System.out.println(person);
    }

}

final class PersonBuilder{

    private int id;
    private String name;
    private String address;
    private Integer height;

    public PersonBuilder(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public PersonBuilder addName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PersonBuilder addAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public PersonBuilder addHeight(Integer height) {
        this.height = height;
        return this;
    }
}
