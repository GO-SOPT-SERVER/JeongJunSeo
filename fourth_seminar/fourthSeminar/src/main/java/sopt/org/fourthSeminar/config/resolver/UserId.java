package sopt.org.fourthSeminar.config.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // -> 어노테이션이 사용될 수 있는 곳 정
@Retention(RetentionPolicy.RUNTIME) // -> 어노테이션이 언제까지 유효할지
public @interface UserId {

}