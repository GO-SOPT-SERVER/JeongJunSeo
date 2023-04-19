package org.example.view.createAccountView;

import org.example.domain.product.Product;
import org.example.view.common.CommonOutputView;

import java.util.List;

public class AccountCreatorOutputView extends CommonOutputView {
    public void showAccountType() {
        System.out.println("======================");
        System.out.println("어떤 계좌를 개설하실지 입력하세요.");
        for (AccountType at : AccountType.values()) {
            System.out.printf("(%d) %s%n", at.ordinal(), at.text);
        }
        System.out.println("======================");
    }

    public void showProducts(List<Product> products) {
        System.out.println("======================");
        System.out.println("상품을 고르세요.");
        int i = 0;
        for (Product p : products) {
            System.out.printf("(%d) %s \n", i, p.getName());
            i++;
        }
        System.out.println("======================");
    }

    public void showNameRequest() {
        System.out.println("======================");
        System.out.println("이름을 입력하세요.");
        System.out.println("======================");
    }

    public void showInitialAmountRequest() {
        System.out.println("======================");
        System.out.println("초기 입금액을 입력하세요.");
        System.out.println("======================");
    }

    public void showInstallmentAmountRequest() {
        System.out.println("======================");
        System.out.println("적금액을 입력하세요.");
        System.out.println("======================");
    }

    public void showTimeAmountRequest() {
        System.out.println("======================");
        System.out.println("예금액을 입력하세요.");
        System.out.println("======================");
    }
}
