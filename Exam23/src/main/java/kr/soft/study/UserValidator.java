package kr.soft.study;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("ȸ������ ��ȿ�� �˻� ����~!");
		User user = (User)target;
		
		checkId(user, errors);
		checkPw(user, errors);
		checkMail(user, errors);
		checkName(user, errors);
		checkIDnum(user, errors);
		checkHobby(user, errors);
		checkIntro(user, errors);
		
	}
	
//	public void checkId(User user, Errors errors) {
//		String userId = user.getId();
//		if(userId == null || userId.trim().isEmpty()) {
//			System.out.println("���̵� ����ֽ��ϴ�.");
//			errors.rejectValue("id", "trouble");
//		}
//		if(userId.length()<4 || userId.length()>13) {
//			System.out.println("���̵� 4�ڸ� �̻� 12�ڸ� ���Ϸ� �Է����ּ���.");
//			errors.rejectValue("id", "trouble");
//		}
//	}
	
	// 2. ValidationUtils API ����ϴ� ���
	public void checkId(User user, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		
		String userId = user.getId();
		if(userId.length()<4 || userId.length()>13) {
			System.out.println("���̵� 4�ڸ� �̻� 12�ڸ� ���Ϸ� �Է����ּ���.");
			errors.rejectValue("id", "trouble");
		}
	}
	
	public void checkPw(User user, Errors errors) {
		String userPw = user.getPw();
		String userSecondPw = user.getSecondPw();
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
	
	public void checkMail(User user, Errors errors) {
		String userMail = user.getMail();
		if(userMail == null || userMail.trim().isEmpty()) {
			System.out.println("���� �ּҸ� �Է����ּ���.");
			errors.rejectValue("mail", "trouble");
		}
		if(userMail.trim().split("@").length!=2) {
			System.out.println("�ùٸ� ���� �ּ� �������� �Է��ϼ���.");
			errors.rejectValue("mail", "trouble");
		}
	}
	
	public void checkName(User user, Errors errors) {
		String userName = user.getName();
		if(userName == null || userName.trim().isEmpty()) {
			System.out.println("�̸��� �Է����ּ���.");
			errors.rejectValue("name", "trouble");
		}
	}
	
	public void checkIDnum(User user, Errors errors) {
		String userIDnum = user.getIDnum();
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
	
	public void checkHobby(User user, Errors errors) {
		String userHobby = user.getHobby();
		String[] hobbyArr = userHobby.split(",");
		if(userHobby == null || userHobby.trim().isEmpty()) {
			System.out.println("���ɺо߸� �������ּ���.");
			errors.rejectValue("hobby", "trouble");
		}
		if(hobbyArr.length<=1) {
			System.out.println("���ɺо߸� 2�� �̻� �������ּ���.");
			errors.rejectValue("hobby", "trouble");
		}
	}
	
	public void checkIntro(User user, Errors errors) {
		String intro = user.getIntroduction();
		if(intro == null || intro.trim().isEmpty()) {
			System.out.println("�ڱ�Ұ��� �Է����ּ���.");
			errors.rejectValue("intro", "trouble");
		}
		if(intro.length()<10) {
			System.out.println("�ڱ�Ұ��� 10�� �̻� �Է����ּ���.");
			errors.rejectValue("intro", "trouble");
		}
	}
	

}
