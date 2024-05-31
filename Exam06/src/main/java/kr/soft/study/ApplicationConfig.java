package kr.soft.study;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정에 사용되는 클래스
public class ApplicationConfig {
	
	@Bean
	public Pencil4B pencil() {
		Pencil4B pencil = new Pencil4B();
		return pencil;
	}
	
//	@Bean
//	public Pencil6B pencil() {
//		Pencil6B pencil = new Pencil6B();
//		return pencil;
//	}
	
//	@Bean
//	public Pencil6BWithEraser pencil() {
//		Pencil6BWithEraser pencil = new Pencil6BWithEraser();
//		return pencil;
//	}

}
