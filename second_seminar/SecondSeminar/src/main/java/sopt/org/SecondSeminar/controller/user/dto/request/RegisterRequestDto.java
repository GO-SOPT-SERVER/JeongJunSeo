package sopt.org.SecondSeminar.controller.user.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 모든 인자를 받는 private 생성자 생성
public class RegisterRequestDto {
    private String gender;

    private String name;

    private String contact;

    private int age;
}
