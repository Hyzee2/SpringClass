package kr.soft.study;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String config = null;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if(str.equals("dev")) {
			config = "dev";
		}else if(str.equals("run")) {
			config = "run";
		}
		
		sc.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 스프링 컨텍스트를 xml 방식으로 설정할 예정. 
		ctx.getEnvironment().setActiveProfiles(config); // 적용될 activeProfiles 속성을 config로 지정 
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml"); // xml 파일 모두 로드 시키기 
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip : "+info.getIpNum());
		System.out.println("port : "+info.getPortNum());
		ctx.close();

	}

}
