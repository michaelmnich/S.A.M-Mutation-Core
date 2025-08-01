package com.uj.atm.Test;

import com.uj.atm.common.AccountSample;
import com.uj.atm.common.CreditCardSample;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {
    /*Test sprawdzający zmianę PINu z poprawnymi danymi, poprawność PINu oraz wpłatę i wypłatę dodatnich kwot w konta  */
    @Test
    public void test01(){
        ICreditCard creditCardSample = new CreditCardSample();
        Assert.assertTrue(creditCardSample.ChangePin("0000", "6789", "6789") == true);
        Assert.assertTrue(creditCardSample.IsPinValid("6789") == true);
        IAccount accountSample = new AccountSample();
        creditCardSample.AddAccount(accountSample);
        Assert.assertTrue(creditCardSample.DepositFunds(90.0) == true);
        Assert.assertTrue(accountSample.AccountStatus() == 90.0);
        Assert.assertTrue(creditCardSample.WithdrawFunds(80.0) == true);
        Assert.assertTrue(accountSample.AccountStatus() == 10.0);

    }

    /*Test sprawdzający zmianę PINu z niepoprawnymi danymi (potwierdzenie nowego PINu jest inne niż nowy PIN),
     poprawność PINu oraz wpłatę i wypłatę dodatnich kwot w konta  */
    @Test
    public void test02(){
        ICreditCard creditCardSample = new CreditCardSample();
        Assert.assertTrue(creditCardSample.ChangePin("0000", "6789", "6788") == false);
        Assert.assertTrue(creditCardSample.IsPinValid("0000") == true);
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        Assert.assertTrue(creditCardSample.DepositFunds(90.0) == true);
        Assert.assertTrue(nazwa.AccountStatus() == 90.0);
        Assert.assertTrue(creditCardSample.WithdrawFunds(80.0) == true);
        Assert.assertTrue(nazwa.AccountStatus() == 10.0);

    }

    /*Test sprawdzający zmianę PINu z niepoprawnymi danymi (stary PIN i nowy PIN są takie same),
     poprawność PINu oraz wpłatę dodatniej kwoty i wypłatę ujemnej kwoty z konta  */
    @Test
    public void test03(){
        ICreditCard creditCardSample = new CreditCardSample();
        Assert.assertTrue(creditCardSample.ChangePin("0000", "0000", "0000") == false);
        Assert.assertTrue(creditCardSample.IsPinValid("0000") == true);
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        Assert.assertTrue(creditCardSample.DepositFunds(90.0) == true);
        Assert.assertTrue(nazwa.AccountStatus() == 90.0);
        Assert.assertTrue(creditCardSample.WithdrawFunds(-80.0) == false);
        Assert.assertTrue(nazwa.AccountStatus() == 90.0);

    }

    /*Test sprawdzający zmianę PINu z poprawnymi danymi ,
     poprawność PINu (zły PIN) oraz wpłatę ujemnej kwoty i wypłatę dodatniej kwoty z konta  */
    @Test
    public void test04(){
        ICreditCard creditCardSample = new CreditCardSample();
        Assert.assertTrue(creditCardSample.ChangePin("0000", "6789", "6789") == true);
        Assert.assertTrue(creditCardSample.IsPinValid("0000") == false);
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        Assert.assertTrue(creditCardSample.DepositFunds(-90.0) == false);
        Assert.assertTrue(nazwa.AccountStatus() == 0.0);
        Assert.assertTrue(creditCardSample.WithdrawFunds(80.0) == false);
        Assert.assertTrue(nazwa.AccountStatus() == 0.0);

    }

    /*Test sprawdzający zmianę PINu z poprawnymi danymi ,
     poprawność PINu oraz wpłatę dodatniej kwoty i wypłatę całej kwoty z konta  */
    @Test
    public void test05(){
        ICreditCard creditCardSample = new CreditCardSample();
        Assert.assertTrue(creditCardSample.ChangePin("0000", "6789", "6789") == true);
        Assert.assertTrue(creditCardSample.IsPinValid("6789") == true);
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        Assert.assertTrue(creditCardSample.DepositFunds(90.0) == true);
        Assert.assertTrue(nazwa.AccountStatus() == 90.0);
        Assert.assertTrue(creditCardSample.WithdrawFunds(90.0) == true);
        Assert.assertTrue(nazwa.AccountStatus() == 0.0);

    }

    /*Test sprawdzający zmianę PINu z poprawnymi danymi ,
     poprawność PINu oraz wpłatę dodatniej kwoty i wypłatę większej kwoty niż jest na koncie  */
    @Test
    public void test06(){
        ICreditCard creditCardSample = new CreditCardSample();
        Assert.assertTrue(creditCardSample.ChangePin("0000", "6789", "6789") == true);
        Assert.assertTrue(creditCardSample.IsPinValid("6789") == true);
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        Assert.assertTrue(creditCardSample.DepositFunds(90.0) == true);
        Assert.assertTrue(nazwa.AccountStatus() == 90.0);
        Assert.assertTrue(creditCardSample.WithdrawFunds(1110.0) == false);
        Assert.assertTrue(nazwa.AccountStatus() == 90.0);

    }
}
