package org.example.domain.accountTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.example.domain.account.SavingAccount;
import org.example.domain.account.TimeDepositAccount;
import org.example.domain.account.constant.AccountStatus;
import org.example.domain.product.SavingProduct;
import org.example.domain.product.TimeDepositProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeDepositAccountTest {

    TimeDepositProduct happyDeposit;
    TimeDepositAccount timeDepositAccount;

    @BeforeEach
    private void init() {
        happyDeposit = TimeDepositProduct.getInstance(0);
        timeDepositAccount = new TimeDepositAccount("0000", "덩둔더", 5_000_000L, happyDeposit);
    }

    @Test
    public void 해지를_시도했는데_만기되지_않았다면_해지는_되지않고_만기되지_않았음을_반환한다() {
        // given
        SavingProduct receiverSavingProduct = SavingProduct.getInstance(0);
        SavingAccount receiverAccount = new SavingAccount("0000", "정준서", 10_000L,
            receiverSavingProduct);
        AccountStatus expectedStatus = AccountStatus.NOT_EXPIRED;
        Long expectedReceiverBalance = receiverAccount.getBalance();
        Long expectedMyBalance = timeDepositAccount.getBalance();

        // when
        AccountStatus actualStatus = timeDepositAccount.closure(receiverAccount);
        Long actualReceiverBalance = receiverAccount.getBalance();
        Long actualMyBalance = timeDepositAccount.getBalance();

        // then
        assertAll(
            () -> assertThat(actualStatus).isEqualTo(expectedStatus),
            () -> assertThat(actualReceiverBalance).isEqualTo(expectedReceiverBalance),
            () -> assertThat(actualMyBalance).isEqualTo(expectedMyBalance)
        );
    }

    @Test
    public void 입력받은_비밀번호가_맞으면_true를_반화한다() {
        // given
        String inputPassword = "0000";
        boolean expected = true;

        // when
        boolean actual = timeDepositAccount.isCorrectPassword(inputPassword);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 입력받은_비밀번호가_틀리면_false를_반화한다() {
        // given
        String inputPassword = "1234";
        boolean expected = false;

        // when
        boolean actual = timeDepositAccount.isCorrectPassword(inputPassword);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}