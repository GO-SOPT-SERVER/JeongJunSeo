package sopt.org.SecondSeminar.controller.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 모든 인자를 받는 private 생성자 생성
public class RegisterRequestDto {
    private String title;

    private String content;

}
