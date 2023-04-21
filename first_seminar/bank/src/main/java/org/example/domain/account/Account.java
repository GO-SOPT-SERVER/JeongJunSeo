package org.example.domain.account;

import java.time.LocalDate;
import java.util.Random;
import org.example.domain.product.Product;

public abstract class Account {

    private final String accountNumber = makeAccountNumber(); // 계좌 번호
    private final String password; // 비밀 번호
    private final String accountHolder; // 예금주 명
    protected Long balance; // 잔액
    private final LocalDate createdDate = LocalDate.now(); // 개설 날짜
    private final Product product; // 상품 정보

    protected Account(
        String password,
        String accountHolder,
        Long initBalance,
        Product product
    ) {
        this.password = password;
        this.balance = initBalance;
        this.accountHolder = accountHolder;
        this.product = product;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public Long getBalance() { // 잔액 조회
        return this.balance;
    }


    private String makeAccountNumber() {
        Random random = new Random();
        StringBuilder randomNumbers = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            randomNumbers.append(random.nextInt(9));
        }
        return randomNumbers.toString();
    }

    public boolean isCorrectPassword(String input) {
        return this.password.equals(input);
    }

}
