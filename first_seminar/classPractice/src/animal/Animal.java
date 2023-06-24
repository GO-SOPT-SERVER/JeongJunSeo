package animal;

public class Animal {
    private String species;
    private String name;
    private int age;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void speak() {
        System.out.println("동물이 소리를 냅니다.");
    }

    public void drink() {
        System.out.print("동물이 물을 마십니다");
    }
}
