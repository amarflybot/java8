package amar.designPattern.creational.builder;

/**
 * Created by amarendra on 26/02/16.
 */
public class BuilderTest {

    public static void main(String[] args) {
        Person.PersonBuilder personBuilder = new Person.PersonBuilder();
        personBuilder.id(1).name("Amar").address("Kadma").height(2);

        Person person = personBuilder.build();
        Person person1 = personBuilder.build();

        System.out.println(System.identityHashCode(person));
        System.out.println(System.identityHashCode(person1));
    }

}

class Person{

    public static class PersonBuilder{
        private int id;
        private String name;
        private String address;
        private Integer height;


        public PersonBuilder id(final int id) {
            this.id = id;
            return this;
        }

        public PersonBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder height(final Integer height) {
            this.height = height;
            return this;
        }


        public Person build() {
            return new Person(this);
        }
    }

    private int id;
    private String name;
    private String address;
    private Integer height;


    public Person(final PersonBuilder personBuilder) {
        this.id = personBuilder.id;
        this.name = personBuilder.name;
        this.address = personBuilder.address;
        this.height = personBuilder.height;
    }


    public void setId(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(final Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Person person = (Person) o;

        if (id != person.id) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        return height != null ? height.equals(person.height) : person.height == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }
}
