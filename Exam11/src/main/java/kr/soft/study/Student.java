package kr.soft.study;

import java.util.ArrayList;

public class Student {
	
	private String name;
	private ArrayList<String> hobbys;
	
	public Student() {
		
	}
	
	public Student(String name, ArrayList<String> hobbys) {
		super();
		this.name = name;
		this.hobbys = hobbys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	

}
