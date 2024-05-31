package kr.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.contact.ContactSet;
import kr.contact.dao.ContactDao;

@Component
public class ContactRegisterService { // 연락처 정보를 데이터베이스에 저장하는 기능 
	
	private ContactDao contactDao;
	
	@Autowired
	public ContactRegisterService(ContactDao contactDao) {
		
		this.contactDao = contactDao;
	}
	
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if(verify(name)) {
			contactDao.insert(contactSet);
		}else {
			System.out.println("이미 존재하는 연락처 입니다. ");
		}
	}
	
	public boolean verify(String name) { // 기존에 등록된 연락처인지 판단하는 메서드 
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null? true : false;
	}
	
	public void setWordDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
