package kr.soft.study;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection connection = ctx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : "+connection.getAdminId());
		System.out.println("admin PW : "+connection.getAdminPw());
		System.out.println("sub_admin ID : "+connection.getSub_adminId());
		System.out.println("sub_admin PW : "+connection.getSub_adminPw());

		ctx.close();
	}

}
