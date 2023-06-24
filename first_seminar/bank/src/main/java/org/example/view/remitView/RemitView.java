package org.example.view.remitView;

import org.example.view.common.CommonInputView;

public class RemitView {
    private RemitOutputView outputView = new RemitOutputView();
    private CommonInputView inputView = new CommonInputView();

    public String getSenderAccountNumber() {
        outputView.showSenderAccountNumberRequest();
        return inputView.inputAccountNumber();
    }

    public String getPassword() {
        outputView.showPasswordRequest();
        return inputView.inputPassword();
    }

    public String getReceiverAccountNumber() {
        outputView.showReceiverAccountNumberRequest();
        return inputView.inputAccountNumber();
    }

    public long getAmount() {
        outputView.showAmountRequest();
        return inputView.inputAmount();
    }
}
