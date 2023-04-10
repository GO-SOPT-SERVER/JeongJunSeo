package generic;

public class Book {

    private String title;
    private int page;

    public Book(String title, int page) {
        this.title = title;
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
            "title='" + title + '\'' +
            ", page=" + page +
            '}';
    }
}
