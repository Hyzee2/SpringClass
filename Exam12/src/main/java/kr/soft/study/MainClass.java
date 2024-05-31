package kr.soft.study;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //생성
		
		ctx.load("classpath:applicationCTX.xml"); //설정
		
		ctx.refresh();
		
		OtherStudent otherstudent = ctx.getBean("student", OtherStudent.class); //사용
		System.out.println("이름: "+otherstudent.getName());
		System.out.println("나이: "+otherstudent.getAge());
		
		ctx.close(); //종료 

	}

}
