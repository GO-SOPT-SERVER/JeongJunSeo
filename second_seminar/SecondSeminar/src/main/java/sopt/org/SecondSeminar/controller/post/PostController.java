package sopt.org.SecondSeminar.controller.post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.SecondSeminar.controller.post.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.service.post.PostService;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public String register(@RequestBody final RegisterRequestDto request) {
        // 서비스 계층에 유저를 등록하는 메서드를 호출
        Long postId = postService.register(request);
//        System.out.println(postList.get(postId.intValue() - 1).toString());

        return postId + "번 게시물이 등록되었습니다!";
    }

    @GetMapping("/post/{postId}")
    public String getOne(@PathVariable final Long postId) {
        Post post = postService.getOne(postId);
//        System.out.println("요청 유저 아이디: " + userId);

        return post != null ? post.toString() : "해당 게시물이 존재하지 않습니다";
    }


    @GetMapping("/post/search")
    public String search(@RequestParam final String title) {
        Post post = postService.search(title);
//        System.out.println("유저 이름 검색 인자: " + name);

        return post != null ? post.toString() : "해당 제목을 가진 게시물이 없습니다";
    }
}
