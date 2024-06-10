package kr.soft.study;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext(); // 동적바인딩. 
		ConfigurableEnvironment env = ctx.getEnvironment(); // env를 접근하기 위한 객체 ConfigurableEnvironment 생성 
		MutablePropertySources propertySources = env.getPropertySources(); // 추가된 프로퍼티를 가져옴
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties")); // 프로퍼티 추가 
			// properties는 데이터의 값을 저장해둔 파일 
			
			System.out.println(env.getProperty("admin.id")); // env를 직접 사용해서 바로 설정 
			System.out.println(env.getProperty("admin.pw"));
			
			System.out.println(env.getProperty("admin1.id"));
			System.out.println(env.getProperty("admin1.pw"));
		}catch(IOException e) {
			
		}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx; // 형변환 
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		// 객체에 담아서 사용하기! env를 필드로 갖고 있는 객체인 경우!  
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class); 
		System.out.println("admin ID : "+adminConnection.getAdminId());
		System.out.println("admin PW : "+adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();

	}

}
