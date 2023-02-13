package Store.bo;

public class emp_bo
{
	private int id;
	private String name;
	private String email;
	private String password;
	private String number;
	
	

	@Override
	public String toString() {
		return "emp_bo [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", number="
				+ number + "]";
	}


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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
