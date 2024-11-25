package model.classes;

import model.enums.Jobdesk;

public class Employee extends NonGuest {
	private Jobdesk jobdesk;

	public Employee(Integer id, String name, String email, String password, String cellphone, Jobdesk jobdesk) {
		super(id, name, email, password, cellphone);
		this.jobdesk = jobdesk;
	}

	public Jobdesk getJobdesk() {
		return jobdesk;
	}

	public void setJobdesk(Jobdesk jobdesk) {
		this.jobdesk = jobdesk;
	}
}
