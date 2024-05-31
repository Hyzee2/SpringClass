package kr.soft.study;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();

	}

}
