package org.example.view.depositView;

import org.example.view.common.CommonInputView;

public class DepositView {
    private DepositOutputView outputView = new DepositOutputView();
    private CommonInputView commonInputView = new CommonInputView();

    public String getAccountNumber() {
        outputView.showAccountNumberRequest();
        return commonInputView.inputAccountNumber();
    }

    public Long getAmount() {
        outputView.showAmountRequest();
        return commonInputView.inputAmount();
    }

    public String controlAccountTypeError() {
        outputView.showAccountTypeError();
        return commonInputView.inputAccountNumber();
    }
}
