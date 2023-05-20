package sopt.org.fourthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSeminar.domain.Post;

public interface PostRepository extends Repository<Post, Long> {
    // create
    Post save(Post post);
}
