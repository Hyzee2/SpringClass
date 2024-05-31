package kr.soft.study;

public class MyCalculator {
	private Calculator calculator; // has-a 관계 
	private int firstNum;
	private int secondNum;

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) { // (외부에서)객체를 주입한다. 
		this.calculator = calculator;
	}
	
	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public void add() {
		this.calculator.addition(this.firstNum, this.secondNum);
	}
	
	public void sub() {
		this.calculator.subtracion(this.firstNum, this.secondNum);
	}
	
	public void mul() {
		this.calculator.multiplication(this.firstNum, this.secondNum);
	}
	
	public void div() {
		this.calculator.division(this.firstNum, this.secondNum);
	}

}
