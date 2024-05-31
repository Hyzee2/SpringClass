package kr.soft.study;

public class Calculator {
	
	public void addition(int firstNum, int secondNum){
		System.out.println("addition()");
		System.out.println(firstNum+" + "+secondNum+" = "+(firstNum+secondNum)); 
	}
	
	public void subtracion(int firstNum, int secondNum) {
		System.out.println("subtracion()");
		System.out.println(firstNum+" - "+secondNum+" = "+(firstNum-secondNum));
	}
	
	public void multiplication(int firstNum, int secondNum) {
		System.out.println("multiplication()");
		System.out.println(firstNum+" * "+secondNum+" = "+firstNum*secondNum);
	}
	
	public void division(int firstNum, int secondNum) {
		System.out.println("division()");
		System.out.println(firstNum+" / "+secondNum+" = "+firstNum/secondNum);
	}

}
