package kr.soft.study;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:applicationCTX.xml","classpath:applicationCTX1.xml"})
public class ApplicationConfig {
	
	@Bean // ��ü ����
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿", hobbys);
		
		return student;
	}
	
	@Bean
	public StudentInfo studentInfo1() {
		StudentInfo studentInfo = new StudentInfo(student1());
		return studentInfo;
	}
	
	@Bean
	public Student student3() {
		Student student = new Student();
		student.setName("ȫ����");
		return student;
	}
	
	@Bean
	public Family family() {
		Family family = new Family("ȫ�ƺ�", "ȫ����");
		family.setSisterName("ȫ����");
		family.setBrotherName("ȫ����");
		return family;
	}

}
