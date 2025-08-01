package com.uj.atm.Test;

import com.uj.atm.common.AccountSample;
import com.uj.atm.common.AtmSample;
import com.uj.atm.common.CreditCardSample;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {

    /*Test sprawdzający stan konta,  wpłatę oraz wypłatę dodatnich kwot z konta oraz
    przelew dodatniej kwoty z konta stowarzyszonego z daną kartą na określone konto  */

    @Test
    public void test01(){
        IAtm atmSample = new AtmSample();
        ICreditCard creditCardSample = new CreditCardSample();
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        atmSample.CheckPinAndLogIn(creditCardSample, "0000");
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.DepositFunds(creditCardSample, 90.0) == true);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 90.0);
        Assert.assertTrue(atmSample.WithdrawFunds(creditCardSample, 10.0) == true);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 80.0);
        IAccount konto2 = new AccountSample();
        Assert.assertTrue(atmSample.Transfer(creditCardSample, konto2, 20.0) == true);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 60.0);
        Assert.assertTrue(atmSample.AccountStatus(konto2) == 20.0);
    }

    /*Test sprawdzający stan konta,  wpłatę oraz wypłatę ujemnych kwot z konta oraz
    przelew ujemnej kwoty z konta stowarzyszonego z daną kartą na określone konto  */

    @Test
    public void test02(){
        IAtm atmSample = new AtmSample();
        ICreditCard creditCardSample = new CreditCardSample();
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        atmSample.CheckPinAndLogIn(creditCardSample, "0000");
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.DepositFunds(creditCardSample, -90.0) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.WithdrawFunds(creditCardSample, -10.0) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        IAccount konto2 = new AccountSample();
        Assert.assertTrue(atmSample.Transfer(creditCardSample, konto2, -20.0) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.AccountStatus(konto2) == 0.0);
    }

    /*Test sprawdzający stan konta,  wpłatę ujemniej kwoty,  wypłatę dodatniej kwoty z konta oraz
    przelew dodatniej kwoty z konta stowarzyszonego z daną kartą z saldem 0.0 na określone konto  */

    @Test
    public void test03(){
        IAtm atmSample = new AtmSample();
        ICreditCard creditCardSample = new CreditCardSample();
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        atmSample.CheckPinAndLogIn(creditCardSample, "0000");
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.DepositFunds(creditCardSample, -10.10) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.WithdrawFunds(creditCardSample, 10.0) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        IAccount konto2 = new AccountSample();
        Assert.assertTrue(atmSample.Transfer(creditCardSample, konto2, 20.0) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.AccountStatus(konto2) == 0.0);
    }

    /*Test sprawdzający stan konta,  wpłatę dodatniej kwoty, wypłatę całej dostępnej kwoty z konta  oraz
    przelew dodatniej kwoty z konta stowarzyszonego z daną kartą na określone konto  */

    @Test
    public void test04(){
        IAtm atmSample = new AtmSample();
        ICreditCard creditCardSample = new CreditCardSample();
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        atmSample.CheckPinAndLogIn(creditCardSample, "0000");
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.DepositFunds(creditCardSample, 10.10) == true);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 10.10);
        Assert.assertTrue(atmSample.WithdrawFunds(creditCardSample, 10.10) == true);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        IAccount konto2 = new AccountSample();
        Assert.assertTrue(atmSample.Transfer(creditCardSample, konto2, 20.0) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.AccountStatus(konto2) == 0.0);
    }

    /*Test sprawdzający stan konta,  wpłatę dodatniej kwoty oraz wypłatę kwoty większej niż jest na koncie oraz
    przelew dodatniej kwoty z konta stowarzyszonego z daną kartą na określone konto  */

    @Test
    public void test05(){
        IAtm atmSample = new AtmSample();
        ICreditCard creditCardSample = new CreditCardSample();
        IAccount nazwa = new AccountSample();
        creditCardSample.AddAccount(nazwa);
        atmSample.CheckPinAndLogIn(creditCardSample, "0000");
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 0.0);
        Assert.assertTrue(atmSample.DepositFunds(creditCardSample, 90.0) == true);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 90.0);
        Assert.assertTrue(atmSample.WithdrawFunds(creditCardSample, 110.0) == false);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 90.0);
        IAccount konto2 = new AccountSample();
        Assert.assertTrue(atmSample.Transfer(creditCardSample, konto2, 20.0) == true);
        Assert.assertTrue(atmSample.AccountStatus(nazwa) == 70.0);
        Assert.assertTrue(atmSample.AccountStatus(konto2) == 20.0);
    }

}
