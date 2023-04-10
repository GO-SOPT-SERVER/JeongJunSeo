package animal;

public class Dog extends Animal {
    private String gender;

    public Dog(String species, String name, int age, String gender) {
        super(species, name, age);
        this.gender = gender;
    }

    @Override
    public void speak() {
        System.out.println("월월");
    }
}
