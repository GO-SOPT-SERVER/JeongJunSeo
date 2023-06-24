package animal;

public class Test {
    // 상속 테스트
    public static void main(String[] args) {
        Animal animal = new Animal("강아지", "초코", 3);
        animal.speak(); // 동물이 소리를 냅니다.

        Dog dog = new Dog("dog","초코", 3, "girl");
        dog.speak(); // 월월

    }
}
