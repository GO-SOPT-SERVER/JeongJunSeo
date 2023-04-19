package org.example.view.createAccountView;

enum AccountType {
    SAVING("입출금 계좌"),
    INSTALLMENT("정기 예금 계좌"),
    TIME("정기 적금 계좌"),
    ;

    public String text;

    AccountType(String text) {
        this.text = text;
    }
}
