package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void ChangePinTest(){
        CreditCard karta = new CreditCard();
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
    }

    @Test
    public void ChangePinManyTimesTest(){
        CreditCard karta = new CreditCard();
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
    }

    @Test
    public void ChangePinManyManyManyManyManyManyManyManyManyManyTimesTest(){
        CreditCard karta = new CreditCard();
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));;
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
    }

    @Test
    public void ChangePinWrongOldPinTest(){
        CreditCard karta = new CreditCard();
        Assert.assertFalse(karta.ChangePin("6666", "6666", "6666"));
    }

    @Test
    public void ChangePinWrongWrongConfirmPinTest(){
        CreditCard karta = new CreditCard();
        Assert.assertFalse(karta.ChangePin("0000", "6666", "9999"));
    }

    @Test
    public void ChangePinWrongWrongConfirmPinAndOldPinTest(){
        CreditCard karta = new CreditCard();
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
    }

    @Test
    public void ChangePinmManyWrongWrongConfirmPinAndOldPinTest(){
        CreditCard karta = new CreditCard();
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
    }

    @Test
    public void ChangePinmTooLongConfirmTest(){
        CreditCard karta = new CreditCard();
        Assert.assertFalse(karta.ChangePin("0000", "666666", "666666"));
    }

    @Test
    public void IsPinValidTest(){
        CreditCard karta = new CreditCard();

        Assert.assertTrue(karta.IsPinValid("0000"));
    }

    @Test
    public void IsPinValidManyTimesTest(){
        CreditCard karta = new CreditCard();

        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertTrue(karta.IsPinValid("0000"));
    }

    @Test
    public void IsPinValidAndChangePinTest(){
        CreditCard karta = new CreditCard();
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertTrue(karta.ChangePin("0000", "6666", "6666"));
        Assert.assertTrue(karta.IsPinValid("6666"));
        Assert.assertTrue(karta.ChangePin("6666", "0000", "0000"));
    }

    @Test
    public void IsPinValidAndWrongChangePinTest(){
        CreditCard karta = new CreditCard();
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertFalse(karta.ChangePin("6666", "6666", "6666"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertFalse(karta.IsPinValid("6666"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertFalse(karta.ChangePin("0000", "6666", "9999"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertFalse(karta.IsPinValid("9999"));
        Assert.assertFalse(karta.IsPinValid("6666"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertFalse(karta.ChangePin("9999", "6666", "9999"));
        Assert.assertTrue(karta.IsPinValid("0000"));
        Assert.assertFalse(karta.IsPinValid("9999"));
        Assert.assertFalse(karta.IsPinValid("6666"));
        Assert.assertTrue(karta.IsPinValid("0000"));
    }

    @Test
    public void AddAccountTest(){
        CreditCard karta = new CreditCard();
        Account konto = new Account();

        karta.AddAccount(konto);
    }

    @Test
    public void AddTwoAccounstTest(){
        CreditCard karta = new CreditCard();
        Account konto1 = new Account();
        Account konto2 = new Account();

        karta.AddAccount(konto1);
        karta.AddAccount(konto2);
    }

    @Test
    public void DepositFundsTest(){
        CreditCard karta = new CreditCard();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(karta.DepositFunds(200));
    }

    @Test
    public void DepositMinusFundsTest(){
        CreditCard karta = new CreditCard();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(karta.DepositFunds(-200));
    }

    @Test
    public void DepositPincetPlusTest(){
        CreditCard karta = new CreditCard();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(karta.DepositFunds(500));
        Assert.assertTrue(konto.AccountStatus()==500);
    }

    @Test
    public void WithdrawFundsTest(){
        CreditCard karta = new CreditCard();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(karta.WithdrawFunds(500));
    }

    @Test
    public void WithdrawFundsAndStatusTest(){
        CreditCard karta = new CreditCard();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(karta.DepositFunds(500));
        Assert.assertTrue(konto.AccountStatus()==500);
        Assert.assertTrue(karta.WithdrawFunds(500));
        Assert.assertTrue(konto.AccountStatus()==0);
    }

    @Test
    public void WithdrawWrongFundsAndStatusTest(){
        CreditCard karta = new CreditCard();
        Account konto = new Account();

        karta.AddAccount(konto);
        Assert.assertTrue(karta.DepositFunds(500));
        Assert.assertTrue(konto.AccountStatus()==500);
        Assert.assertTrue(karta.WithdrawFunds(-500));
        Assert.assertFalse(konto.AccountStatus()==0);
    }
}
