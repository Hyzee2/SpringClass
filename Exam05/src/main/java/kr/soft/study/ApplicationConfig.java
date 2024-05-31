package kr.soft.study;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정에 사용되는 클래스
public class ApplicationConfig {
	
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo();
		Student student1 = new Student();
		student1.setName("김근미");
		student1.setAge("26");
		student1.setGradeNum("4");
		student1.setClassNum("1");
		studentInfo.setStudent(student1);
		return studentInfo;
	}
	
	@Bean
	public Student student2() {
		Student student2 = new Student();
		student2.setName("꼬몽");
		student2.setAge("3");
		student2.setGradeNum("2");
		student2.setClassNum("3");
		return student2;
	}
	
	@Bean
	public StudentInfo studentInfo2() {
		StudentInfo studentInfo2 = new StudentInfo(student2());
		
		return studentInfo2;
	}
	
	@Bean
	public Student student4() {
		Student student4 = new Student();
		student4.setName("어피치");
		student4.setAge("5");
		student4.setGradeNum("2");
		student4.setClassNum("5");
		return student4;
	}

}
