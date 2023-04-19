package org.example.view.createAccountView;

import org.example.view.common.CommonInputView;

import java.util.Scanner;

public class AccountCreatorInputView extends CommonInputView {
    public int inputAccountType() {
        Scanner input = new Scanner(System.in);
        int action = input.nextInt();
        if (action < 0 || action > AccountType.values().length) {
            System.out.println("존재하지 않는 요청입니다. 다시 고르세요.");
            return inputAccountType();
        }
        return action;
    }

    public int inputProduct(int size){
        Scanner input = new Scanner(System.in);
        int action = input.nextInt();
        if (action < 0 || action > size) {
            System.out.println("존재하지 않는 요청입니다. 다시 고르세요.");
            return inputProduct(size);
        }
        return action;
    }
}
