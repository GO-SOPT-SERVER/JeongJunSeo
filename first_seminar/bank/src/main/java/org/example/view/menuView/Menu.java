package org.example.view.menuView;

public enum Menu {
    DEPOSIT("입금"),
    WITHDRAWAL("출금"),
    REMIT("송금"),
    CREATE_ACCOUNT("계좌 개설"),
    CHECK_ACCOUNT("잔액 조회"),
    CHECK_INTERST("이자 조회")
    ;

    public final String text;

    Menu(String text) {
        this.text = text;
    }
}
