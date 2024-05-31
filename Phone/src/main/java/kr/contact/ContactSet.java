package kr.contact;

public class ContactSet { // 연락처 정보를 담는 클래스 
	
	private String name;
	private String phoneNumber;
	
	public ContactSet() {
		
	}
	
	public ContactSet(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
