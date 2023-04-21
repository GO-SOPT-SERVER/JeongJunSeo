package generic;

public class Test {
    // 제네릭 테스트
    public static void main (String[] args) {
        Box<Book> bookBox = new Box<>();
        bookBox.addItem(new Book("객체지향의 사실과 오해", 324));
        bookBox.getItem();
    }
}
