package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToBalanceWithInitialBalance() {
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3500, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -2_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldAddZeroAmountToBalanceWithInitialBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmountToBalanceWithInitialBalance() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );

        account.add(-500);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldNotThrowExceptionWithPositiveParams() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
    }

    @Test
    public void shouldThrowAnExceptionWithZeroRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    5_000,
                    0
            );
        });
    }

    @Test
    public void shouldThrowAnExceptionWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    5_000,
                    -15
            );
        });
    }

    @Test
    public void shouldThrowAnExceptionWithZeroCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    0,
                    15
            );
        });
    }

    @Test
    public void shouldThrowAnExceptionWithNegativeCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    -5_000,
                    15
            );
        });
    }

    @Test
    public void shouldThrowAnExceptionWithNegativeBalanceMoreThanCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -10_000,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldPayWithInitialBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void shouldPayWithPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldNotPayWithZeroBalanceOverCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(10_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayWithNegativeBalanceInCreditLimit() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void shouldNotPayWithNegativeBalanceOverCreditLimit() {
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );

        account.pay(10_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test
    public void shouldNotPayNegativeAmountWithPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(-1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldCalcRateWithPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalcRateWithZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalcRateWithNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );
        Assertions.assertEquals(-30, account.yearChange());
    }

}
