package kr.soft.study;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//@Aspect
public class LogAop {
	
//	@Pointcut("within(kr.soft.study.*)") // kr.soft.study ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//	@Pointcut("within(kr.soft.study..*)") // kr.soft.study ��Ű�� �� ���� ��Ű�� �ȿ� �ִ� ��� �޼ҵ� 
//	@Pointcut("within(kr.soft.study.Worker)") // kr.soft.study.Worker ��� �޼ҵ� 
//	
//	@Pointcut("bean(*ker)") // -ker�� ������ �󿡸� ���� 
//	@Pointcut("bean(student)") // student �󿡸� ���� 
//	
//	@Pointcut("execution(public void get*(..))") // public void�� ��� get �޼ҵ忡�� ���� 
//	@Pointcut("execution(* kr.soft.study.*.*())") // kr.soft.study ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�   
//	@Pointcut("execution(* kr.soft.study..*.*())") // kr.soft.study ��Ű�� & kr.soft.study ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//	@Pointcut("execution(* kr.soft.study.Worker.*())") // kr.soft.study.Worker ���� ��� �޼ҵ� 
	private void pointcutMethod() {
		
	}
	
//	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable{
		String signature = joinpoint.getSignature().toShortString();
		System.out.println(signature + "is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			long et = System.currentTimeMillis();
			System.out.println(signature + "is finished.");
			System.out.println(signature + "����ð�: " + (et - st));
		}
	}
	
//	@Before("pointcutMethod()")
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforeAdvice()");
		
	}
	
//	@AfterReturning("pointcutMethod()")
	public void afterReturningAdvice(JoinPoint joinpoint) {
		System.out.println("afterReturningAdvice()");
		
	}
	
//	@AfterThrowing("pointcutMethod()")
	public void afterThrowingAdvice(JoinPoint joinpoint) {
		System.out.println("afterThrowingAdvice()");
		
	}
	
//	@After("pointcutMethod()")
	public void afterAdvice(JoinPoint joinpoint) {
		System.out.println("afterAdvice()");
		
	}

}
