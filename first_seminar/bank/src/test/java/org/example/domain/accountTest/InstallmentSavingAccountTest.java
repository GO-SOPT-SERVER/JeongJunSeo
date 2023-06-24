package org.example.domain.accountTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.example.domain.account.InstallmentSavingAccount;
import org.example.domain.account.SavingAccount;
import org.example.domain.account.constant.AccountStatus;
import org.example.domain.product.InstallmentSavingProduct;
import org.example.domain.product.SavingProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstallmentSavingAccountTest {

    InstallmentSavingProduct militarySaving;
    InstallmentSavingAccount dundeoAccount;

    @BeforeEach
    void init() {
        militarySaving = InstallmentSavingProduct.getInstance(0);
        dundeoAccount = new InstallmentSavingAccount("0000", "덩둔더", 100_000L, militarySaving);
    }

    @Test
    void 십만원을_입금하면_잔액이_십만원_늘어난다() {
        // given
        Long expected = dundeoAccount.getBalance() + 10_000L;
        // when
        dundeoAccount.deposit(10_000L);
        Long actual = dundeoAccount.getBalance();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 해지를_시도했는데_만기되지_않았다면_해지는_되지않고_만기되지_않았음을_반환한다() {
        // given
        SavingProduct studentSaving = SavingProduct.getInstance(0);
        SavingAccount junseoAccount = new SavingAccount("0000", "정준서", 10_000L, studentSaving);
        AccountStatus expectedStatus = AccountStatus.NOT_EXPIRED;
        Long expectedBalance = junseoAccount.getBalance();

        // when
        AccountStatus actualStatus = dundeoAccount.closure(junseoAccount);
        Long actualBalance = junseoAccount.getBalance();

        // then
        assertAll(
            () -> assertThat(actualStatus).isEqualTo(expectedStatus),
            () -> assertThat(actualBalance).isEqualTo(expectedBalance)
        );
    }


    @Test
    void 입력받은_비밀번호가_맞으면_true를_반화한다() {
        // given
        String inputPassword = "0000";
        boolean expected = true;

        // when
        boolean actual = dundeoAccount.isCorrectPassword(inputPassword);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 입력받은_비밀번호가_틀리면_false를_반화한다() {
        // given
        String inputPassword = "1234";
        boolean expected = false;

        // when
        boolean actual = dundeoAccount.isCorrectPassword(inputPassword);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}