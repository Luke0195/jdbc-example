package entities;

public class BeanUserPhone {
	
	private String name;
	private String email;
	private String phone1;
	private String phone2;
	
	public BeanUserPhone() {}

	public BeanUserPhone(String name, String email, String phone1, String phone2) {
		super();
		this.name = name;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	@Override
	public String toString() {
		return "BeanUserPhone [name=" + name + ", email=" + email + ", phone1=" + phone1 + ", phone2=" + phone2 + "]";
	}
	
	
	
}
