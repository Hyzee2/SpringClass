package kr.soft.study;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // ������ ������ ���Ǵ� Ŭ����
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
