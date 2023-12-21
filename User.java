
public abstract class User {
	
	private int id;
	private String nameSurname;
	private String phoneNum;
	private String address;
	private String userType;
	
	public User() {
		
	}


	public User(int id, String nameSurname, String phoneNum, String address, String userType) {
		this.id = id;
		this.nameSurname = nameSurname;
		this.phoneNum = phoneNum;
		this.address = address;
		this.userType = userType;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameSurname() {
		return nameSurname;
	}


	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "User id = " + id + 
				"\nName Surname = " + nameSurname + 
				"\nPhone Number = " + phoneNum + 
				"\nAddress = " + address + "\n";
	}
	
}
