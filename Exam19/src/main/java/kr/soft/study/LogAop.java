package kr.soft.study;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
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
	
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforeAdvice()");
		
	}
	
	public void afterReturningAdvice(JoinPoint joinpoint) {
		System.out.println("afterReturningAdvice()");
		
	}
	
	public void afterThrowingAdvice(JoinPoint joinpoint) {
		System.out.println("afterThrowingAdvice()");
		
	}
	
	public void afterAdvice(JoinPoint joinpoint) {
		System.out.println("afterAdvice()");
		
	}

}
