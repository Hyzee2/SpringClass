package kr.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.contact.ContactSet;
import kr.contact.dao.ContactDao;

@Component
public class ContactRegisterService { // ����ó ������ �����ͺ��̽��� �����ϴ� ��� 
	
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
			System.out.println("�̹� �����ϴ� ����ó �Դϴ�. ");
		}
	}
	
	public boolean verify(String name) { // ������ ��ϵ� ����ó���� �Ǵ��ϴ� �޼��� 
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null? true : false;
	}
	
	public void setWordDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
