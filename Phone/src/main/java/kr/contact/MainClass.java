package kr.contact;

import org.springframework.context.support.GenericXmlApplicationContext;

import kr.contact.service.ContactRegisterService;
import kr.contact.service.ContactSearchService;
import kr.contact.utils.InitSampleData;

public class MainClass {
	
	public static void main(String[] args) {
		
		// IoC �����̳� ����
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		// ���� ������
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] names = initSampleData.getNames();
		String[] phoneNumbers = initSampleData.getPhoneNumbers();
		
		// ������ ���
		ContactRegisterService registerService = ctx.getBean("registerService", ContactRegisterService.class);
		for(int i=0; i<names.length; i++) {
			ContactSet contactSet = new ContactSet(names[i], phoneNumbers[i]);
			registerService.register(contactSet);
		}
		
		// ������ ��ȸ
		ContactSearchService searchService = ctx.getBean("searchService", ContactSearchService.class);
		ContactSet contactSet = searchService.searchContact("��ٹ�");
		System.out.println("�̸�: "+contactSet.getName());
		System.out.println("����ó: "+contactSet.getPhoneNumber());
		System.out.println("====================================");
		
		contactSet = searchService.searchContact("�쳻��");
		System.out.println("�̸�: "+contactSet.getName());
		System.out.println("����ó: "+contactSet.getPhoneNumber());
		System.out.println("====================================");
		
		contactSet = searchService.searchContact("������");
		System.out.println("�̸�: "+contactSet.getName());
		System.out.println("����ó: "+contactSet.getPhoneNumber());
		System.out.println("====================================");
		
		ctx.close();
	}

}
