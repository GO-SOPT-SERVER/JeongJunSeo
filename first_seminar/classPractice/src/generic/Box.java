package generic;

public class Box<T> {

    private T item;

    public void addItem(T item) {
        this.item = item;
    }

    public void getItem() {
        System.out.println(item);
    }
}
