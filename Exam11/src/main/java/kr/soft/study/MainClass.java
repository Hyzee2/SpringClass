package kr.soft.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String configLocation1 = "classpath:applicationCTX.xml";
//		String configLocation2 = "classpath:applicationCTX1.xml";
//		AbstractApplicationContext ctx 
//		         = new GenericXmlApplicationContext(configLocation1, configLocation2);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	//È«±æµ¿
		System.out.println(student1.getHobbys());	// ¼ö¿µ, ¿ä¸®
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();	//student1  == student2
		System.out.println(student2.getName());	//È«±æµ¿
		System.out.println(student2.getHobbys());	// ¼ö¿µ, ¿ä¸®
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2"); // student1 == student2
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName()); // È«±æÀÚ 
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");  // student1 != student3
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());  //  È«¾Æºü
		System.out.println(family.getMamiName());  // È¨¾ö¸¶
		System.out.println(family.getSisterName()); // È«´©³ª
		System.out.println(family.getBrotherName()); // È«¿Àºü
		
		ctx.close();
		

	}

}
