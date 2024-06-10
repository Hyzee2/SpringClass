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
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext(); // �������ε�. 
		ConfigurableEnvironment env = ctx.getEnvironment(); // env�� �����ϱ� ���� ��ü ConfigurableEnvironment ���� 
		MutablePropertySources propertySources = env.getPropertySources(); // �߰��� ������Ƽ�� ������
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties")); // ������Ƽ �߰� 
			// properties�� �������� ���� �����ص� ���� 
			
			System.out.println(env.getProperty("admin.id")); // env�� ���� ����ؼ� �ٷ� ���� 
			System.out.println(env.getProperty("admin.pw"));
			
			System.out.println(env.getProperty("admin1.id"));
			System.out.println(env.getProperty("admin1.pw"));
		}catch(IOException e) {
			
		}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx; // ����ȯ 
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		// ��ü�� ��Ƽ� ����ϱ�! env�� �ʵ�� ���� �ִ� ��ü�� ���!  
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class); 
		System.out.println("admin ID : "+adminConnection.getAdminId());
		System.out.println("admin PW : "+adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();

	}

}
