package kr.soft.study;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("��ȿ�� �˻� ����!");
		Student student = (Student)target;
		
		/*
		 * String studentName = student.getName(); if(studentName == null ||
		 * studentName.trim().isEmpty()) { System.out.println("�̸��� ����ֽ��ϴ�.");
		 * errors.rejectValue("name", "trouble"); }
		 */
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble"); // �� �ٷ� API ����ϱ�(string���¸� ����)
		
		/*
		 * String studentId = student.getId(); if(studentId == null ||
		 * studentId.trim().isEmpty()) { System.out.println("���̵� ����ֽ��ϴ�.");
		 * errors.rejectValue("id", "trouble"); }
		 */
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		
	}
}
