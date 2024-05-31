package kr.soft.study;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculation calculation = new Calculation();
		calculation.setFirstNum(10);
		calculation.setSecondNum(2);
		
		calculation.addition();
		calculation.subtracion();
		calculation.multiplication();
		calculation.division();

	}

}
