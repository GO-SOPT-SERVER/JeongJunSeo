package sopt.org.SecondSeminar;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sopt.org.SecondSeminar.domain.post.Post;
import sopt.org.SecondSeminar.domain.user.User;

@SpringBootApplication
public class SecondSeminarApplication {
	public static ArrayList<User> userList;

	public static ArrayList<Post> postList;

	public static void main(String[] args) {
		SpringApplication.run(SecondSeminarApplication.class, args);
		userList = new ArrayList<>();
		postList = new ArrayList<>();
	}

}
