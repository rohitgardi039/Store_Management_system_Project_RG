package Store.bo;

public class store_bo
{
	private int id;
	private String name;
	private String email;
	private String phone;
	private String doj;
	private String dob;
	private String adhar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public store_bo(String name, String email, String phone, String doj, String dob, String adhar) {
		super();
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.doj = doj;
		this.dob = dob;
		this.adhar = adhar;
	}
	public store_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static int Update(store_bo rt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	

}
