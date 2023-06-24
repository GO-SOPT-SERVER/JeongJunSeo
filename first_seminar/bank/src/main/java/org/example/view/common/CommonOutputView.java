package org.example.view.common;

public class CommonOutputView {

    public final void showAccountNumberRequest() {
        System.out.println("======================");
        System.out.println("계좌 번호를 입력하세요.");
        System.out.println("----------------------");
    }

    public final void showWrongAccountNumber() {
        System.out.println("======================");
        System.out.println("존재하지 않는 계좌번호 입니다.");
        System.out.println("======================");
    }

    public final void showPasswordRequest() {
        System.out.println("======================");
        System.out.println("계좌 비밀번호를 입력하세요.");
        System.out.println("----------------------");
    }

    public void showWrongPassword() {
        System.out.println("======================");
        System.out.println("비밀번호가 일치하지 않습니다.");
        System.out.println("======================");
    }
}
