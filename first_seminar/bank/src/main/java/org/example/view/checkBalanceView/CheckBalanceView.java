package org.example.view.checkBalanceView;

public class CheckBalanceView {
    private CheckBalanceInputView inputView = new CheckBalanceInputView();
    private CheckBalanceOutputView outputView = new CheckBalanceOutputView();

    private String getAccountNumber() {
        outputView.showAccountNumberRequest();
        return inputView.inputAccountNumber();
    }

    private String getPassword() {
        outputView.showPasswordRequest();
        return inputView.inputPassword();
    }

    private void showBalance(Long balance) {
        outputView.showBalance(balance);
    }

}