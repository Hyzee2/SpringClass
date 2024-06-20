package kr.soft.study.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.soft.study.dto.UDto;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UDto udto = (UDto)target;
		
		checkId(udto, errors);
		checkPw(udto, errors);
		checkMail(udto, errors);
		checkName(udto, errors);
		checkIDnum(udto, errors);
		checkHobby(udto, errors);
		checkIntro(udto, errors);
		
	}
	
	public void checkId(UDto udto, Errors errors) {
		String userId = udto.getId();
		if(userId == null || userId.trim().isEmpty()) {
			System.out.println("���̵� ����ֽ��ϴ�.");
			errors.rejectValue("id", "trouble");
		}
		if(userId.length()<4 || userId.length()>13) {
			System.out.println("���̵� 4�ڸ� �̻� 12�ڸ� ���Ϸ� �Է����ּ���.");
			errors.rejectValue("id", "trouble");
		}
	}
	
	public void checkPw(UDto udto, Errors errors) {
		String userPw = udto.getPw();
		String userSecondPw = udto.getSecondPw();
		if(userPw == null || userPw.trim().isEmpty()) {
			System.out.println("��й�ȣ�� ����ֽ��ϴ�.");
			errors.rejectValue("pw", "trouble");
		}
		if(userPw.length()<4) {
			System.out.println("��й�ȣ�� 4�ڸ� �̻� �Է����ּ���.");
			errors.rejectValue("pw", "trouble");
		}
		if(userPw.replaceAll("[0-9a-z]", "").isEmpty()) {
			System.out.println("��й�ȣ�� Ư�����ڰ� ���� �մϴ�.");
			errors.rejectValue("pw", "trouble");
		}
		if(!userPw.equals(userSecondPw)) {
			System.out.println("������ ��й�ȣ�� �Է����ּ���.");
			errors.rejectValue("secondPw", "trouble");
		}
	}
	
	public void checkMail(UDto udto, Errors errors) {
		String userMail = udto.getMail();
		if(userMail == null || userMail.trim().isEmpty()) {
			System.out.println("���� �ּҸ� �Է����ּ���.");
			errors.rejectValue("mail", "trouble");
		}
		if(userMail.trim().split("@").length!=2) {
			System.out.println("�ùٸ� ���� �ּ� �������� �Է��ϼ���.");
			errors.rejectValue("mail", "trouble");
		}
	}
	
	public void checkName(UDto udto, Errors errors) {
		String userName = udto.getName();
		if(userName == null || userName.trim().isEmpty()) {
			System.out.println("�̸��� �Է����ּ���.");
			errors.rejectValue("name", "trouble");
		}
	}
	
	public void checkIDnum(UDto udto, Errors errors) {
		String userIDnum = udto.getIDnum();
		if(userIDnum == null || userIDnum.trim().isEmpty()) {
			System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ���.");
			errors.rejectValue("IDnum", "trouble");
		}
		if(userIDnum.length()!=13) {
			System.out.println("�ֹε�Ϲ�ȣ ��ü�� �Է����ּ���.");
			errors.rejectValue("IDnum", "trouble");
		} 
		if(userIDnum.length()==13) {
			String[] arr = userIDnum.split("", 13);
			int[] IDnumArr = new int[13];
			int sum = 0;
			
			for(int i=0; i<arr.length; i++) {
				IDnumArr[i] = Integer.parseInt(arr[i]);
			}
			for(int i=0; i<=7; i++) {
				IDnumArr[i] = IDnumArr[i] * (i+2);
			}
			for(int i=8; i<=11; i++) {
				IDnumArr[i] = IDnumArr[i] * (i-6);
			}
			for(int i=0; i<12; i++) {
				sum += IDnumArr[i];
			}
			
			int temp = 11 - (sum%11);
			
			if(temp>=10) {
				temp = temp-10;
			}
			if(temp != IDnumArr[12]) {
				System.out.println("�ùٸ� �ֹε�Ϲ�ȣ�� �Է��ϼ���.");
				errors.rejectValue("IDnum", "trouble");
			}
		}
	}
	
	public void checkHobby(UDto udto, Errors errors) {
		String userHobby = udto.getHobby();
		if(userHobby == null || userHobby.trim().isEmpty()) {
			System.out.println("���ɺо߸� �������ּ���.");
			errors.rejectValue("hobby", "trouble");
		}
		if(userHobby!=null) {
			String[] hobbyArr = userHobby.split(",");
			if(hobbyArr.length<=1) {
				System.out.println("���ɺо߸� 2�� �̻� �������ּ���.");
				errors.rejectValue("hobby", "trouble");
			}
		}
	}
	
	public void checkIntro(UDto udto, Errors errors) {
		String introduction = udto.getIntroduction();
		if(introduction == null || introduction.trim().isEmpty()) {
			System.out.println("�ڱ�Ұ��� �Է����ּ���.");
			errors.rejectValue("introduction", "trouble");
		}
		if(introduction.length()<10) {
			System.out.println("�ڱ�Ұ��� 10�� �̻� �Է����ּ���.");
			errors.rejectValue("introduction", "trouble");
		}
	}
	

}
