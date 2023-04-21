package sopt.org.SecondSeminar.controller.user;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.user.User;
import sopt.org.SecondSeminar.service.user.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String register(@RequestBody final RegisterRequestDto request) {
        Long userId = userService.register(request);
//        System.out.println(userList.get(userId.intValue() - 1).toString());

        return userId + "번 유저가 등록되었습니다!";
    }

    @GetMapping("/user/{userId}")
    public String getOne(@PathVariable final Long userId) {
        User user = userService.getOne(userId);
//        System.out.println("요청 유저 아이디: " + userId);

        return user != null ? user.toString() : "해당 유저가 존재하지 않습니다";
    }

    @GetMapping("/user/search")
    public String search(@RequestParam final String name) {
        User user = userService.search(name);
//        System.out.println("유저 이름 검색 인자: " + name);

        return user != null ? user.toString() : "해당 이름을 가진 유저가 없습니다";
    }

}
