package org.example.domain.account;

import org.example.domain.product.Product;

// 적금
public class InstallmentSavingAccount extends FixedTermAccount implements Depositable {

    private final Long installmentAmount; // 매달 입금액

    public InstallmentSavingAccount(
        String password,
        String accountHolder,
        Long initBalance,
        Product product
    ) {
        super(password, accountHolder, initBalance, product);
        this.installmentAmount = initBalance;
    }

    @Override
    public void deposit(Long amount) { // 입금
        this.balance += amount;
    }

    @Override
    protected Long getFinalInterest() {
        Float result = this.installmentAmount * this.getProduct().getInterestRate() / 100 * (this.getProduct().getPeriod() + 1) / 2;
        return result.longValue();
    }

}
