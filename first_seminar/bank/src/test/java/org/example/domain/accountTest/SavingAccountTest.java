package org.example.domain.accountTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.example.domain.account.SavingAccount;
import org.example.domain.account.constant.AccountStatus;
import org.example.domain.product.SavingProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingAccountTest {

    SavingProduct studentSaving;
    SavingAccount junseoAccount;

    @BeforeEach
    void init() {
        studentSaving = SavingProduct.getInstance(0);
        junseoAccount = new SavingAccount("0000", "정준서", 100_000L, studentSaving);
    }

    @Test
    void 오만원을_입금하면_잔액이_오만원_늘어난다() {
        // given
        Long expected = junseoAccount.getBalance() + 50_000L;
        // when
        junseoAccount.deposit(50_000L);
        Long actual = junseoAccount.getBalance();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 오만원을_출금하면_잔액이_오만원_감소하고_성공을_반환한다() {
        // given
        Long expectedBalance = junseoAccount.getBalance() - 50_000L;
        AccountStatus expectedStatus = AccountStatus.WITHDRAWAL_SUCCESS;

        // when
        AccountStatus actualStatus = junseoAccount.withdrawal(50_000L);
        Long actualBalance = junseoAccount.getBalance();

        // then
        assertAll(
            () -> assertThat(actualBalance).isEqualTo(expectedBalance),
            () -> assertThat(actualStatus).isEqualTo(expectedStatus)
        );
    }

    @Test
    void 잔액인_10만원보다_많은_15만원을_출금하면_잔액이_감소하지않고_실패를_반환한다() {
        // given
        Long expectedBalance = junseoAccount.getBalance();
        AccountStatus expectedStatus = AccountStatus.WITHDRAWAL_FAIL;

        // when
        AccountStatus actualStatus = junseoAccount.withdrawal(150_000L);
        Long actualBalance = junseoAccount.getBalance();

        // then
        assertAll(
            () -> assertThat(actualBalance).isEqualTo(expectedBalance),
            () -> assertThat(actualStatus).isEqualTo(expectedStatus)
        );
    }

    @Test
    void 오만원_송금하면_잔액이_오만원_감소하고_상대계좌의_잔액이_오만원_증가하며_성공을_반환한다() {
        // given
        SavingAccount motherAccount = new SavingAccount("1111", "엄마", 5_000_000L, studentSaving);
        Long expectedMotherBalance = motherAccount.getBalance() + 50_000L;
        Long expectedMyBalance = junseoAccount.getBalance() - 50_000L;
        AccountStatus expectedStatus = AccountStatus.REMIT_SUCCESS;

        // when
        AccountStatus actualStatus = junseoAccount.remit(motherAccount, 50_000L);
        Long actualMotherBalance = motherAccount.getBalance();
        Long actualMyBalance = junseoAccount.getBalance();

        // then
        assertAll(
            () -> assertThat(actualMotherBalance).isEqualTo(expectedMotherBalance),
            () -> assertThat(actualMyBalance).isEqualTo(expectedMyBalance),
            () -> assertThat(actualStatus).isEqualTo(expectedStatus)
        );
    }

    @Test
    void 송금에_실패하면_잔액에_변동이없고_실패를_반환한다() {
        SavingAccount motherAccount = new SavingAccount("1111", "엄마", 5_000_000L, studentSaving);
        Long expectedMotherBalance = motherAccount.getBalance();
        Long expectedMyBalance = junseoAccount.getBalance();
        AccountStatus expectedStatus = AccountStatus.REMIT_FAILURE;

        // when
        AccountStatus actualStatus = junseoAccount.remit(motherAccount, 150_000L);
        Long actualMotherBalance = motherAccount.getBalance();
        Long actualMyBalance = junseoAccount.getBalance();

        // then
        assertAll(
            () -> assertThat(actualMotherBalance).isEqualTo(expectedMotherBalance),
            () -> assertThat(actualMyBalance).isEqualTo(expectedMyBalance),
            () -> assertThat(actualStatus).isEqualTo(expectedStatus)
        );
    }

    @Test
    void 이자지급_함수를_호출하면_잔액이_이자만큼_증가한다() {
        // given
        Long expected = (long) (junseoAccount.getBalance()
            + junseoAccount.getBalance() * junseoAccount.getProduct().getInterestRate() / 100);

        // when
        junseoAccount.receiveInterest();
        Long actual = junseoAccount.getBalance();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 입력받은_비밀번호가_맞으면_true를_반화한다() {
        // given
        String inputPassword = "0000";
        boolean expected = true;

        // when
        boolean actual = junseoAccount.isCorrectPassword(inputPassword);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 입력받은_비밀번호가_틀리면_false를_반화한다() {
        // given
        String inputPassword = "1234";
        boolean expected = false;

        // when
        boolean actual = junseoAccount.isCorrectPassword(inputPassword);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}