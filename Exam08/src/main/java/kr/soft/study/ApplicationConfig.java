package kr.soft.study;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // ������ ������ ���Ǵ� Ŭ����
public class ApplicationConfig {

	@Bean // ��ü ����
	public Student student1() {

		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");

		Student student = new Student("ȫ�浿", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);

		return student;
	}
	@Bean 
	public Student student2() {

		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("���");
		hobbys.add("��ȭ");

		Student student = new Student("ȫ����", 50, hobbys);
		student.setHeight(160);
		student.setWeight(50);

		return student;
	}

}
