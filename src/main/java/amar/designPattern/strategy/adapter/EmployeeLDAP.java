package amar.designPattern.strategy.adapter;

public class EmployeeLDAP {

	private String cname;
	private String firstname;
	private String roll;

	public EmployeeLDAP(String cname, String firstName, String roll) {
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
