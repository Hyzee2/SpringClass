package kr.soft.study;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration // 스프링 설정에 사용되는 클래스
@ImportResource("classpath:applicationCTX.xml")
public class ApplicationConfig {

	@Bean // 객체 주입
	public Student student1() {

		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");

		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);

		return student;
	}

}
