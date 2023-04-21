package org.example.view.createAccountView;

import java.util.List;
import org.example.domain.product.Product;

public class AccountCreatorView {
    private AccountCreatorOutputView outputView = new AccountCreatorOutputView();
    private AccountCreatorInputView inputView = new AccountCreatorInputView();

    public AccountType getAccountType() {
        outputView.showAccountType();
        return inputView.inputAccountType();
    }

    public int getProductType(List<Product> products) {
        outputView.showProducts(products);
        return inputView.inputProduct(products.size());
    }

    public String getName() {
        outputView.showNameRequest();
        return inputView.inputName();
    }

    public String getPassword() {
        outputView.showPasswordRequest();
        return inputView.inputPassword();
    }

    public long getInitialAmount() {
        outputView.showInitialAmountRequest();
        return inputView.inputAmount();
    }

    public long getInstallmentAmount() {
        outputView.showInstallmentAmountRequest();
        return inputView.inputAmount();
    }

    public long getTimeAmount() {
        outputView.showTimeAmountRequest();
        return inputView.inputAmount();
    }

    public void accountCreateSuccess() {
        outputView.showCreateSuccess();
    }
}
