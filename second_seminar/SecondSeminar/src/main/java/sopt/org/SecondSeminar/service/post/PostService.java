package sopt.org.SecondSeminar.service.post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;
import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;

@Service
public class PostService {
    public Long register(RegisterRequestDto request) {
        Post newPost = new Post(
            request.getTitle(),
            request.getContent()
        );

        // 데이터베이스에 저장
        postList.add(newPost);
        newPost.setId((long) postList.size());

        // 저장한 포스트 아이디 값 반환
        return newPost.getId();
    }

    public Post getOne(Long postId) {
        if (postId > postList.size())
            return null;

        return postList.get(postId.intValue() - 1);
    }

    public Post search(String title) {
        for (Post post : postList) {
            if (post.getTitle().equals(title)) {
                return post;
            }
        }
        return null;
    }
}
