package kr.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.contact.ContactSet;
import kr.contact.dao.ContactDao;

@Component
public class ContactSearchService { // Ư�� ����ó�� ã�� ��� 
	
	private ContactDao contactDao;

	@Autowired
	public ContactSearchService(ContactDao contactDao) {
		
		this.contactDao = contactDao;
	}
	
	public ContactSet searchContact(String name) {
		if(verify(name)) {
			return contactDao.select(name);
		}else {
			System.out.println("�ش� ����ó�� ��ȿ�մϴ�. ");
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
