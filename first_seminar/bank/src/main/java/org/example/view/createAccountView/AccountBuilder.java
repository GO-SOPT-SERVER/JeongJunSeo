package org.example.view.createAccountView;

import org.example.domain.account.Account;
import org.example.domain.account.InstallmentSavingAccount;
import org.example.domain.account.SavingAccount;
import org.example.domain.account.TimeDepositAccount;
import org.example.domain.product.Product;

import java.util.NoSuchElementException;

public class AccountBuilder {
    private String password = null;
    private String accountHolder = null;
    private Long initBalance = null;
    private Product product = null;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setInitBalance(Long initBalance) {
        this.initBalance = initBalance;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account build(AccountType accountType) {
        switch (accountType) {
            case SAVING: {
                return new SavingAccount(password, accountHolder, initBalance, product);
            }
            case INSTALLMENT: {
                return new InstallmentSavingAccount(password, accountHolder, initBalance, product);
            }
            case TIME: {
                return new TimeDepositAccount(password, accountHolder, initBalance, product);
            }
            default: {
                throw new NoSuchElementException("없는 계좌 타입입니다.");
            }
        }
    }
}
