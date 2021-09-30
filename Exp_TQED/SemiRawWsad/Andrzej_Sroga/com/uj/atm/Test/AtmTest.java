package com.uj.atm.Test;
import com.uj.atm.common.Account;
import com.uj.atm.common.Atm;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class AtmTest {
    @Test
    public void CheckPinAndLogIn__Check(){
        Atm atm=new Atm();

        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),"1113")==true);

        String[] inlineData={"111","11111","a234", "123a","","123;","12\n4","12\r","H123","1  4"};

        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[0])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[1])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[2])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[3])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[4])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[5])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[6])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[7])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[8])==false);
        Assert.assertTrue(atm.CheckPinAndLogIn(new CreditCard(),inlineData[9])==false);

        Boolean expected = true;
        Boolean result;
        result= atm.CheckPinAndLogIn(new CreditCard(),"1234");
        Assert.assertTrue(result.equals(expected));

        expected=false;
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[0]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[1]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[2]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[3]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[4]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[5]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[6]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[7]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[8]);
        Assert.assertTrue(result.equals(expected));
        result= atm.CheckPinAndLogIn(new CreditCard(),inlineData[9]);
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void AccountStatus__Check(){
        CreditCard creditCard=new CreditCard("1234");
        Account account=new Account(100);
        creditCard.AddAccount(account);

        Assert.assertTrue(creditCard.iaccount.AccountStatus()==100);

        Double expected = 100d;
        Double result;
        result= creditCard.iaccount.AccountStatus();
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void ChacgePin_Check(){
        Atm atm=new Atm();
        Assert.assertTrue(atm.ChangePinCard(new CreditCard("1234"),"1234","4444","4444")==true);

        Boolean expected = true;
        Boolean result;
        result= atm.ChangePinCard(new CreditCard("1234"),"1234","4444","4444");
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void Deposit__Check() {
        Atm atm = new Atm();
        Assert.assertTrue(atm.DepositFunds(new CreditCard(), 100) == true);


        Boolean expected = true;
        Boolean result;
        result = atm.DepositFunds(new CreditCard(), 100);
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void Withdraw__Check() {
        Atm atm = new Atm();
        CreditCard creditCard=new CreditCard();
        Account account=new Account(300);
        creditCard.AddAccount(account);
        Assert.assertTrue(atm.WithdrawFunds(creditCard, 100) == true);


        Boolean expected = true;
        Boolean result;
        result = atm.DepositFunds(new CreditCard(), 100);
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void Transfer__Check() {
        Atm atm = new Atm();
        CreditCard creditCard=new CreditCard();
        Account account=new Account(400);
        creditCard.AddAccount(account);

        Account account2=new Account(100);

        Assert.assertTrue(atm.Transfer(creditCard,account,100)==true);


        Boolean expected = true;
        Boolean result;
        result = atm.Transfer(creditCard,account,100);
        Assert.assertTrue(result.equals(expected));
    }
}
