package sopt.org.SecondSeminar.domain.post;


import lombok.Getter;

@Getter
public class Post {

    private Long id;

    private String title;

    private String content;


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "title: " + this.title + "\n" +
            "content: " + this.content;
    }

}
