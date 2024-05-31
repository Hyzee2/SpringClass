package kr.soft.study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Pencil pencil = ctx.getBean("pencil", Pencil.class); // 동적바인딩
		pencil.use();
		
		ctx.close();

	}

}
