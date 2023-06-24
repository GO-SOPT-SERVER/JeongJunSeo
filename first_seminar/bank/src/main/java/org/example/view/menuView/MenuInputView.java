package org.example.view.menuView;

import java.util.Scanner;

public class MenuInputView {
    public int inputAction() {
        Scanner input = new Scanner(System.in);
        int action = input.nextInt();
        if (action < 0 || action >= Menu.values().length) {
            System.out.println("존재하지 않는 요청입니다. 다시 고르세요.");
            return inputAction();
        }
        return action;
    }
}
