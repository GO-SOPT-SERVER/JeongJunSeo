package org.example;

import org.example.domain.account.SavingAccount;
import org.example.domain.product.SavingProduct;
import org.example.view.createAccountView.AccountCreatorView;
import org.example.view.menuView.MenuView;

public class Bank {

    public void run() {
        MenuView menuView = new MenuView();
        int order = menuView.getMenuChoice();

        AccountCreatorView accountCreatorView = new AccountCreatorView();

        int accountType = -1;
        if (order == 3) {
            accountType = accountCreatorView.getAccountType();
        }

        int productId = -1;
        switch (accountType) {
            case 0:
                productId = accountCreatorView.getProductType(SavingProduct.products);
                break;
        }

        String name = accountCreatorView.getName();
        String password = accountCreatorView.getPassword();
        Long initBalance = accountCreatorView.getInitialAmount();

        SavingAccount savingAccount = new SavingAccount(password, name, initBalance,
            SavingProduct.getInstance(productId));

    }

}