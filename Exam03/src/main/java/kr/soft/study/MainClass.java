package kr.soft.study;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * MyCalculator myCalculator = new MyCalculator();
		 * myCalculator.setCalculator(new Calculator()); // 객체 주입하는 부분 
		 * 
		 * myCalculator.setFirstNum(10); myCalculator.setSecondNum(2);
		 * 
		 * myCalculator.add(); myCalculator.sub(); myCalculator.mul();
		 * myCalculator.div();
		 */
		
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		
		//myCalculator.setFirstNum(20); // 직접 필드를 설정할 수도 있다. 
		
		myCalculator.add(); 
		myCalculator.sub(); 
		myCalculator.mul();
		myCalculator.div();

	}

}
