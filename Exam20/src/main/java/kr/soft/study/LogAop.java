package kr.soft.study;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//@Aspect
public class LogAop {
	
//	@Pointcut("within(kr.soft.study.*)") // kr.soft.study 패키지 안에 있는 모든 메소드
//	@Pointcut("within(kr.soft.study..*)") // kr.soft.study 패키지 및 하위 패키지 안에 있는 모든 메소드 
//	@Pointcut("within(kr.soft.study.Worker)") // kr.soft.study.Worker 모든 메소드 
//	
//	@Pointcut("bean(*ker)") // -ker로 끝나는 빈에만 적용 
//	@Pointcut("bean(student)") // student 빈에만 적용 
//	
//	@Pointcut("execution(public void get*(..))") // public void인 모든 get 메소드에만 적용 
//	@Pointcut("execution(* kr.soft.study.*.*())") // kr.soft.study 패키지에 파라미터가 없는 모든 메소드   
//	@Pointcut("execution(* kr.soft.study..*.*())") // kr.soft.study 패키지 & kr.soft.study 하위 패키지에 파라미터가 없는 모든 메소드
//	@Pointcut("execution(* kr.soft.study.Worker.*())") // kr.soft.study.Worker 안의 모든 메소드 
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
			System.out.println(signature + "경과시간: " + (et - st));
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
