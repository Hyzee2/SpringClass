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
		System.out.println("유효성 검사 시작!");
		Student student = (Student)target;
		
		/*
		 * String studentName = student.getName(); if(studentName == null ||
		 * studentName.trim().isEmpty()) { System.out.println("이름이 비어있습니다.");
		 * errors.rejectValue("name", "trouble"); }
		 */
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble"); // 한 줄로 API 사용하기(string형태만 가능)
		
		/*
		 * String studentId = student.getId(); if(studentId == null ||
		 * studentId.trim().isEmpty()) { System.out.println("아이디가 비어있습니다.");
		 * errors.rejectValue("id", "trouble"); }
		 */
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		
	}
}
