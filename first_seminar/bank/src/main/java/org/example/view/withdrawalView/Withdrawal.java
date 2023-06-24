package org.example.view.withdrawalView;

import org.example.view.common.CommonInputView;

public class Withdrawal {
    private WithdrawalOutputView outputView = new WithdrawalOutputView();
    private CommonInputView inputView = new CommonInputView();

    public String getAccountNumber() {
        outputView.showAccountNumberRequest();
        return inputView.inputAccountNumber();
    }

    public String getPassword() {
        outputView.showPasswordRequest();
        return inputView.inputPassword();
    }

    public Long getAmount() {
        outputView.showAmountRequest();
        return inputView.inputAmount();
    }
}
