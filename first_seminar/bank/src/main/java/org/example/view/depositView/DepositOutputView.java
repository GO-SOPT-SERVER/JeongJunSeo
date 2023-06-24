package org.example.view.depositView;

import org.example.view.common.CommonOutputView;

public class DepositOutputView extends CommonOutputView {

    public void showAmountRequest() {
        System.out.println("======================");
        System.out.println("계좌를 찾았습니다.");
        System.out.println("입금할 액수를 입력하세요.");
        System.out.println("======================");
    }

    public void showAccountTypeError() {
        System.out.println("======================");
        System.out.println("입금이 가능한 계좌가 아닙니다.");
        System.out.println("입금할 계좌 번호를 입력하세요.");
        System.out.println("======================");
    }
}
