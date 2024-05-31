package kr.soft.study;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:applicationCTX.xml","classpath:applicationCTX1.xml"})
public class ApplicationConfig {
	
	@Bean // 按眉 林涝
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("荐康");
		hobbys.add("夸府");
		
		Student student = new Student("全辨悼", hobbys);
		
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
		student.setName("全辨磊");
		return student;
	}
	
	@Bean
	public Family family() {
		Family family = new Family("全酒狐", "全决付");
		family.setSisterName("全穿唱");
		family.setBrotherName("全坷狐");
		return family;
	}

}
