package kr.soft.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx =
				 new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
		
		System.out.println("admin ID : "+connection.getAdminId());
		System.out.println("admin PW : "+connection.getAdminPw());
		System.out.println("sub_admin ID : "+connection.getSub_adminId());
		System.out.println("sub_admin PW : "+connection.getSub_adminPw());
		
		ctx.close();
	}

}
