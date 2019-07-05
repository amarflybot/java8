package amar.designPattern.structural.adapter;

public class AdapterDemo {

    public static void main(final String[] args) {

        final EmployeeClient employeeClient = new EmployeeClient();
        employeeClient.addEmployee(new EmployeeDB("123", "Amar", "4"));

        final EmployeeLDAP employeeLdap = new EmployeeLDAP("123", "Amar", "4");

        employeeClient.addEmployee(new EmployeeAdapterLDAP(employeeLdap));

    }

}
