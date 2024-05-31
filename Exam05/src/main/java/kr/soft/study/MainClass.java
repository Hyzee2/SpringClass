package kr.soft.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
//		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getStudentInfo();
		
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
		
		StudentInfo studentInfo2 = ctx.getBean("studentInfo2", StudentInfo.class);
		studentInfo2.getStudentInfo();
		
		Student student4 = ctx.getBean("student4", Student.class);
		studentInfo.setStudent(student4);
		studentInfo.getStudentInfo();
		
		ctx.close();

	}

}
