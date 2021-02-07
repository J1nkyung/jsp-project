package web.controls;


import java.lang.annotation.*;

// 클래스 파일에 이 정보가 기록되고 실행시에도 유지된다. 
// 즉, 실행시에 클래스에 기록된 annotation 값을 참조할 수 있다 
//runtime = 실행시 component의 정보가 기록된다 
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
	String value() default "";
}
