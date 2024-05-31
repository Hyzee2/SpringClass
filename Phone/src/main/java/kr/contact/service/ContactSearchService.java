package kr.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.contact.ContactSet;
import kr.contact.dao.ContactDao;

@Component
public class ContactSearchService { // 특정 연락처를 찾는 기능 
	
	private ContactDao contactDao;

	@Autowired
	public ContactSearchService(ContactDao contactDao) {
		
		this.contactDao = contactDao;
	}
	
	public ContactSet searchContact(String name) {
		if(verify(name)) {
			return contactDao.select(name);
		}else {
			System.out.println("해당 연락처는 유효합니다. ");
		}
		
		return null;
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	

}
