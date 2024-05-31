package kr.soft.study;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //����
		
		ctx.load("classpath:applicationCTX.xml"); //����
		
		ctx.refresh();
		
		OtherStudent otherstudent = ctx.getBean("student", OtherStudent.class); //���
		System.out.println("�̸�: "+otherstudent.getName());
		System.out.println("����: "+otherstudent.getAge());
		
		ctx.close(); //���� 

	}

}
