package org.example.view.remitView;

import org.example.view.common.CommonOutputView;

public class RemitOutputView extends CommonOutputView {
    public void showSenderAccountNumberRequest() {
        System.out.println("======================");
        System.out.println("어느 계좌에서 송금하실 건가요?");
        System.out.println("계좌번호를 입력하세요");
        System.out.println("======================");
    }

    public void showReceiverAccountNumberRequest() {
        System.out.println("======================");
        System.out.println("어느 계좌로 송금하실 건가요?");
        System.out.println("계좌번호를 입력하세요");
        System.out.println("======================");
    }

    public void showAmountRequest() {
        System.out.println("======================");
        System.out.println("얼마를 출금할 것인지 입력하세요.");
        System.out.println("======================");
    }
}
