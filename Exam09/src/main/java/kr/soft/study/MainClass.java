package kr.soft.study;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");

		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("이름: "+student1.getName());
		System.out.println("나이: "+student1.getAge());
		System.out.println("취미: "+student1.getHobbys());
		System.out.println("신장: "+student1.getHeight());
		System.out.println("몸무게: "+student1.getWeight());
		
		System.out.println("======================================");
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("이름: "+student2.getName());
		System.out.println("나이: "+student2.getAge());
		System.out.println("취미: "+student2.getHobbys());
		System.out.println("신장: "+student2.getHeight());
		System.out.println("몸무게: "+student2.getWeight());
		
		ctx.close();
	}

}
