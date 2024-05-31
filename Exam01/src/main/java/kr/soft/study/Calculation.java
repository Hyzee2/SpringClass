package kr.soft.study;

public class Calculation {
	private int firstNum;
	private int secondNum;
	
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
	
	public void addition(){
		System.out.println("addition()");
		System.out.println(firstNum+" + "+secondNum+" = "+(firstNum+secondNum)); 
	}
	
	public void subtracion() {
		System.out.println("subtracion()");
		System.out.println(firstNum+" - "+secondNum+" = "+(firstNum-secondNum));
	}
	
	public void multiplication() {
		System.out.println("multiplication()");
		System.out.println(firstNum+" * "+secondNum+" = "+firstNum*secondNum);
	}
	
	public void division() {
		System.out.println("division()");
		System.out.println(firstNum+" / "+secondNum+" = "+firstNum/secondNum);
	}

}
