package kr.soft.study;

public class StudentInfo {
	
	private Student student;
	
	public StudentInfo() {
		
	}

	public StudentInfo(Student student) {
		super();
		this.student = student;
	}
	
	public void getStudentInfo() {
		if(student!=null) {
			System.out.println("�̸�: "+student.getName());
			System.out.println("����: "+student.getAge());
			System.out.println("�г�: "+student.getGradeNum());
			System.out.println("��: "+student.getClassNum());
			System.out.println("============================");
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
