package amar.designPattern.structural.adapter;

public class EmployeeDB implements Employee {

    private String id;
    private String name;
    private String roll;

    public EmployeeDB(final String id, final String name, final String roll) {
        super();
        this.id = id;
        this.name = name;
        this.roll = roll;
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRoll() {
        return this.roll;
    }

}
