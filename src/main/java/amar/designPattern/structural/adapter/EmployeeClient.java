package amar.designPattern.structural.adapter;

import java.util.HashMap;
import java.util.Map;

public class EmployeeClient {

    Map<String, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        if (employeeMap.get(employee).getID() == null) {
            employeeMap.put(employee.getID(), employee);
        } else {
            throw new RuntimeException("Employee Already Exists");
        }
    }

    public Employee getEmployeeById(String id) {
        return employeeMap.get(id);
    }
}
