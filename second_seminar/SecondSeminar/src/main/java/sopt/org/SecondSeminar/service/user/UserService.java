package sopt.org.SecondSeminar.service.user;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.user.User;

@Service
public class UserService {
    public Long register(RegisterRequestDto request) {
        User newUser = new User(
            request.getGender(),
            request.getName(),
            request.getContact(),
            request.getAge()
        );

        // 데이터베이스에 저장
        userList.add(newUser);
        newUser.setId((long) userList.size());

        // 저장한 유저 아이디 값 반환
        return newUser.getId();
    }

    public User getOne(Long userId) {
        if (userId > userList.size())
            return null;

        return userList.get(userId.intValue() - 1);
    }

    public User search(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
