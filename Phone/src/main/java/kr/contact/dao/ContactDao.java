package kr.contact.dao;

import java.util.HashMap;
import java.util.Map;

import kr.contact.ContactSet;

public class ContactDao { // 데이터베이스에 접속. 데이터의 insert, search 기능 수행 
	
	private Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();
	
	public Map<String, ContactSet> getContactDB() {
		return contactDB;
	}

	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);
	}
	
	public ContactSet select(String name) {
		return contactDB.get(name);
	}
	

}
