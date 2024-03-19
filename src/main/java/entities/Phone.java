package entities;

public class Phone {

	private Long id;
	private String phone1;
	private String phone2;
	private Long userId;

	public Phone() {
	}

	public Phone(Long id, String phone1, String phone2, Long userId) {
		super();
		this.id = id;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", phone1=" + phone1 + ", phone2=" + phone2 + ", userId=" + userId + "]";
	}
	
	

}
