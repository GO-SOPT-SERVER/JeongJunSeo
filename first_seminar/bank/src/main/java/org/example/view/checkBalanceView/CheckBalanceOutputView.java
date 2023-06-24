package org.example.view.checkBalanceView;

import org.example.view.common.CommonOutputView;

public class CheckBalanceOutputView extends CommonOutputView {
    public void showBalance(Long balance) {
        System.out.println("======================");
        System.out.println("해당 계좌의 잔액은 다음과 같습니다.");
        System.out.println("----------------------");
        System.out.printf("%d 원\n", balance);
        System.out.println("======================");
    }
}
