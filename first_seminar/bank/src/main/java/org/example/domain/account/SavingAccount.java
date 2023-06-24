package org.example.domain.account;

import org.example.domain.account.constant.AccountStatus;
import org.example.domain.product.Product;

public class SavingAccount extends Account implements Depositable {

    public SavingAccount(
        String password,
        String accountHolder,
        Long initBalance,
        Product product
    ) {
        super(password, accountHolder, initBalance, product);
    }

    @Override
    public void deposit(Long amount) { // 입금
        this.balance += amount;
    }

    public AccountStatus withdrawal(Long amount) { // 출금
        if (balance >= amount) {
            this.balance -= amount;
            return AccountStatus.WITHDRAWAL_SUCCESS;
        }
        return AccountStatus.WITHDRAWAL_FAIL;
    }

    public AccountStatus remit(Depositable another, Long amount) {
        AccountStatus result = withdrawal(amount);
        if (result == AccountStatus.WITHDRAWAL_SUCCESS) {
            another.deposit(amount);
            return AccountStatus.REMIT_SUCCESS;
        }
        return AccountStatus.REMIT_FAILURE;
    }

    public void receiveInterest() { // 이자 받기
        Float interest = this.getBalance() * this.getProduct().getInterestRate() / 100;
        this.balance += interest.longValue();
    }
}
