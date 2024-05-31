package kr.contact.utils;

public class InitSampleData { // 프로그램 실행에 필요한 샘플 데이터로 실제 데이터는 appCtx.xml에서 설정함
	
	private String[] names;
	private String[] phoneNumbers;
	
	public String[] getNames() {
		return names;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	
}
