package org.example;

import java.util.ArrayList;
import org.example.domain.account.Account;
import org.example.domain.product.InstallmentSavingProduct;
import org.example.domain.product.Product;
import org.example.domain.product.SavingProduct;
import org.example.domain.product.TimeDepositProduct;
import org.example.view.checkBalanceView.CheckBalanceView;
import org.example.view.createAccountView.AccountBuilder;
import org.example.view.createAccountView.AccountCreatorOutputView;
import org.example.view.createAccountView.AccountCreatorView;
import org.example.view.createAccountView.AccountType;
import org.example.view.menuView.MenuView;

import java.util.NoSuchElementException;

public class Bank {

    private static ArrayList<Account> accountList = new ArrayList<>();
    public void run() {
        MenuView menuView = new MenuView();
        int order = menuView.getMenuChoice();

        switch (order) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                createAccount();
                break;
            }
            case 4: {
                checkBalance();
                break;
            }
            default: {
                break;
            }
        }

        run();
    }

    private Account createAccount() {
        AccountCreatorView creatorView = new AccountCreatorView();
        AccountType accountType = creatorView.getAccountType();

        Product product;
        AccountBuilder builder = new AccountBuilder();
        switch (accountType) {
            case SAVING: {
                int productId = creatorView.getProductType(SavingProduct.products);
                product = SavingProduct.getInstance(productId);
                break;
            }
            case INSTALLMENT: {
                int productId = creatorView.getProductType(InstallmentSavingProduct.products);
                product = InstallmentSavingProduct.getInstance(productId);
                break;
            }
            case TIME: {
                int productId = creatorView.getProductType(TimeDepositProduct.products);
                product = TimeDepositProduct.getInstance(productId);
                break;
            }
            default: {
                throw new NoSuchElementException("없는 계좌 타입입니다.");
            }
        }

        builder.setAccountHolder(creatorView.getName());
        builder.setPassword(creatorView.getPassword());
        builder.setInitBalance(creatorView.getInitialAmount());
        builder.setProduct(product);
        Account newAccount = builder.build(accountType);
        accountList.add(newAccount);
        creatorView.accountCreateSuccess(newAccount);
        return newAccount;
    }

    private void checkBalance() {
        CheckBalanceView checkBalanceView = new CheckBalanceView();
        Account account = searchAccountByAccountNumber(checkBalanceView.getAccountNumber());
        while (account == null) {
            checkBalanceView.showWrongAccountNumber();
            account = searchAccountByAccountNumber(checkBalanceView.getAccountNumber());
        }
        boolean isRightPwd = account.isCorrectPassword(checkBalanceView.getPassword());
        while ( !isRightPwd ) {
            checkBalanceView.showWrongPassword();
            isRightPwd = account.isCorrectPassword(checkBalanceView.getPassword());
        }
        checkBalanceView.showBalance(account.getBalance());
    }

    private Account searchAccountByAccountNumber(String accountNumber) {
        for (Account account : accountList) {
            if (accountNumber.equals(account.getAccountNumber())) {
                return account;
            }
        }
        return null;
    }
}
