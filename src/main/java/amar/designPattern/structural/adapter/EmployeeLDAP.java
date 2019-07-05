package amar.designPattern.structural.adapter;

public class EmployeeLDAP {

    private String cname;
    private String firstname;
    private String roll;

    public EmployeeLDAP(final String cname, final String firstName, final String roll) {
        this.cname = cname;
        this.firstname = firstName;
        this.roll = roll;
    }

    public String getCname() {
        return cname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getRoll() {
        return roll;
    }


}
