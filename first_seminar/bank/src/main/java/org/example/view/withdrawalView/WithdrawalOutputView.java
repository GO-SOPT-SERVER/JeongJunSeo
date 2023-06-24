package org.example.view.withdrawalView;

import org.example.view.common.CommonOutputView;

public class WithdrawalOutputView extends CommonOutputView {
    public void showMenu() {
        System.out.println("======================");
        System.out.println("출금할 계좌 번호를 입력하세요.");
        System.out.println("======================");
    }



    public void showAmountRequest() {
        System.out.println("======================");
        System.out.println("출금할 금액을 입력하세요.");
        System.out.println("======================");
    }
}
