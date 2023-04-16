package org.example.domain.account;

import org.example.domain.product.Product;

public class TimeDepositAccount extends FixedTermAccount {

    public TimeDepositAccount(
        String password,
        String accountHolder,
        Long initBalance,
        Product product
    ) {
        super(password, accountHolder, initBalance, product);
    }

    @Override
    protected Long getFinalInterest() {
        Float result = this.balance * this.getProduct().getInterestRate() / 100;
        return result.longValue();
    }
}
