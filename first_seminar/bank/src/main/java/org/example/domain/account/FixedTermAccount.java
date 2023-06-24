package org.example.domain.account;

import java.time.LocalDate;
import org.example.domain.account.constant.AccountStatus;
import org.example.domain.product.Product;

public abstract class FixedTermAccount extends Account {

    private final LocalDate expireDate = getCreatedDate().plusMonths(getProduct().getPeriod());

    protected FixedTermAccount(
        String password,
        String accountHolder,
        Long initBalance,
        Product product
    ) {
        super(password, accountHolder, initBalance, product);
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public AccountStatus closure(SavingAccount another) { // 해지
        if (isExpired()) { // 만기 됐으면
            this.balance += getFinalInterest();
            another.deposit(this.balance);
            this.balance = 0L;
            return AccountStatus.CLOSURE_SUCCESS;
        }
        // 만기 안됐으면
        return AccountStatus.NOT_EXPIRED;
    }

    public Long checkFinalAmount() {
        return this.balance + getFinalInterest();
    }

    protected abstract Long getFinalInterest();

    private boolean isExpired() {
        return LocalDate.now().isAfter(expireDate);
    }
}
