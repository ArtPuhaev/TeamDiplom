package ru.netology.javaqadiplom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingAccountTest {
    private SavingAccount account;

    @BeforeEach
    public void setUp() {
        account = new SavingAccount(1000, 0, 5000, 10);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testAddPositiveAmount() {
        assertTrue(account.add(500));
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testAddExceedingMaxBalance() {
        assertFalse(account.add(5000)); 
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testAddNegativeAmount() {
        assertFalse(account.add(-100));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testPayValidAmount() {
        assertTrue(account.pay(500));
        assertEquals(500, account.getBalance());
    }

    @Test
    public void testPayExceedingBalance() {
        assertFalse(account.pay(1500)); 
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testPayNegativeAmount() {
        assertFalse(account.pay(-100));
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testYearChangeCalculation() {
        int expectedInterest = 100; 
        assertEquals(expectedInterest, account.yearChange());
    }

    @Test
    public void testConstructorWithInvalidParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1000, 2000, 1500, 10); 
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(1000, 0, 5000, -5); 
        });
    }
}
