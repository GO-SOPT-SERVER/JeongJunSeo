package sopt.org.fourthSeminar.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.fourthSeminar.controller.dto.request.PostRequestDto;
import sopt.org.fourthSeminar.domain.Post;
import sopt.org.fourthSeminar.domain.User;
import sopt.org.fourthSeminar.exception.model.NotFoundException;
import sopt.org.fourthSeminar.infrastructure.PostRepository;
import sopt.org.fourthSeminar.infrastructure.UserRepository;
import sopt.org.fourthSeminar.exception.Error;
@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public void create(Long userId, PostRequestDto request) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Post newBoard = Post.newInstance(
            user,
            request.getTitle(),
            request.getContent(),
            request.getIsPublic()
        );

        postRepository.save(newBoard);
    }
}
