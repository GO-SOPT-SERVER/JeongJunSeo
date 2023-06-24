package org.example.view.menuView;

public class MenuOutputView {
    public void showMenu() {
        System.out.println("======================");
        System.out.println("원하시는 요청을 고르세요.");
        for (Menu m : Menu.values()) {
            System.out.printf("(%d) %s%n", m.ordinal(), m.text);
        }
        System.out.println("======================");
    }
}
