package amar.algorithm.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amarendra on 15/09/17.
 */
public class SortEmployeeById {


    public static void main(final String[] args) {

        final List<Employee> employeeList = Arrays.asList("1,Amar", "2,Vicky", "3,Alka")
                .stream()
                .map(string -> string.split(","))
                .map(strings -> new Employee(Long.parseLong(strings[0]), strings[1]))
                .collect(Collectors.toList());

        System.out.println("employeeList -> " + employeeList);

        employeeList.sort(Comparator.naturalOrder());

        System.out.println("Sorted employeeList -> " + employeeList);
    }

}

class Employee implements Comparable<Employee> {
    private Long id;
    private String name;

    public Employee(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(final Employee o) {
        return (-1 * this.id.compareTo(o.getId()));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
