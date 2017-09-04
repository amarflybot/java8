package amar.designPattern.strategy.adapter;

public class EmployeeAdapterLDAP implements Employee {

	private EmployeeLDAP employeeLDAP;

	public EmployeeAdapterLDAP(EmployeeLDAP employeeLdap) {
		this.employeeLDAP = employeeLdap;
	}

	@Override
	public String getID() {
		return this.employeeLDAP.getCname();
	}

	@Override
	public String getName() {
		return this.employeeLDAP.getFirstname();
	}

	@Override
	public String getRoll() {
		return this.employeeLDAP.getRoll();
	}

}
