package org.example.view.common;

import java.util.Scanner;

public class CommonInputView {

    public final String inputAccountNumber() {
        Scanner input = new Scanner(System.in);
        String inputAccountNumber = input.next();
        if (inputAccountNumber.length() != 8) {
            System.out.println("계좌 번호는 여덟자리 입니다. 다시 입력하세요");
            return inputAccountNumber();
        }
        if (!isStringDigit(inputAccountNumber)) {
            System.out.println("계좌 번호는 숫자만 가능합니다. 다시 입력하세요");
            return inputAccountNumber();
        }
        return inputAccountNumber;
    }

    private boolean isStringDigit(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public final String inputPassword() {
        Scanner input = new Scanner(System.in);
        String pw = input.next();
        if (pw.length() != 4) {
            System.out.println("비밀번호는 네자리 입니다. 다시 입력하세요");
            return inputPassword();
        }
        if (!isStringDigit(pw)) {
            System.out.println("계좌 번호는 숫자만 가능합니다. 다시 입력하세요");
            return inputPassword();
        }
        return pw;
    }

    public final Long inputAmount() {
        Scanner input = new Scanner(System.in);
        long amount = input.nextLong();
        if (amount <= 0) {
            System.out.println("0이하로는 입금할 수 없습니다. 다시 입력하세요");
            return inputAmount();
        }
        return amount;
    }

    public final String inputName() {
        Scanner input = new Scanner(System.in);
        String inputPassword = input.next();
        return inputPassword;
    }
}
