package com.uj.atm.Test;
import com.uj.atm.common.Account;
import com.uj.atm.common.CreditCard;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {


    @Test
    public void ChangePin_IsInputOldPinSameLikeOldPin_IsNewPinSameLikeNewPinConfirm(){
        ICreditCard creditCard=new CreditCard("1234");
        Assert.assertTrue(creditCard.ChangePin("1234","5678","5678")==true);

        ICreditCard creditCard1=new CreditCard("8888");
        Boolean result = creditCard1.ChangePin("8888","5678","5678");
        Boolean expected = true;
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void ChangePin_IsInputOldPinSameLikeOldPin_IsNewPinDifferentThanNewPinConfirm(){
        ICreditCard creditCard=new CreditCard("1234");
        Assert.assertTrue(creditCard.ChangePin("1234","5678","9999")!=true);

        ICreditCard creditCard1=new CreditCard("8888");
        Boolean result = creditCard1.ChangePin("8888","9999","5678");
        Boolean expected = false;
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void ChangePin_IsInputOldPinDifferentThanOldPin_IsNewPinSameLikeNewPinConfirm(){
        ICreditCard creditCard=new CreditCard("1234");
        Assert.assertTrue(creditCard.ChangePin("9999","5678","5678")!=true);

        ICreditCard creditCard1=new CreditCard("8888");
        Boolean result = creditCard1.ChangePin("9999","5678","5678");
        Boolean expected = false;
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void ChangePin_IsInputOldPinDifferentThanOldPin_IsNewPinDifferentThanNewPinConfirm(){
        ICreditCard creditCard=new CreditCard("1234");
        Assert.assertTrue(creditCard.ChangePin("9999","4444","5678")!=true);

        ICreditCard creditCard1=new CreditCard("8888");
        Boolean result = creditCard1.ChangePin("9999","4444","5678");
        Boolean expected = false;
        Assert.assertTrue(result.equals(expected));
    }


    @Test
    public void IsValid_IsRegexWorksProperly(){
        String[] inlineData={"111","11111","a234", "123a","","123;","12\n4","12\r","H123","1  4"};
        ICreditCard creditCard=new CreditCard("1234");
        Assert.assertTrue(creditCard.IsPinValid(inlineData[0])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[1])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[2])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[3])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[4])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[5])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[6])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[7])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[8])!=true);
        Assert.assertTrue(creditCard.IsPinValid(inlineData[9])!=true);

        Boolean expected = false;
        Boolean result;
        result=creditCard.IsPinValid(inlineData[0]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[1]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[2]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[3]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[4]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[5]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[6]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[7]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[8]);
        Assert.assertTrue(result.equals(expected));
        result=creditCard.IsPinValid(inlineData[9]);
        Assert.assertTrue(result.equals(expected));

    }


    @Test
    public void AddAccount_TestIfAccountAssignedToACard(){
        CreditCard creditCard=new CreditCard("1234");
        Boolean expected = true;
        Boolean result;
        //check if iaccount is null
        Assert.assertTrue((creditCard.iaccount==null)==true);
        result=(creditCard.iaccount==null);
        Assert.assertTrue(result.equals(expected));

        Account account=new Account(100);
        creditCard.AddAccount(account);

        //when iaccount is null
        Assert.assertTrue((creditCard.iaccount!=null)==true);
        Assert.assertTrue(creditCard.iaccount.AccountStatus()==100);
        result=(creditCard.iaccount!=null);
        Assert.assertTrue(result.equals(expected));

        //account already assigned
        creditCard.AddAccount(new Account(200));
        Assert.assertTrue((creditCard.iaccount!=null)==true);
        Assert.assertTrue(creditCard.iaccount.AccountStatus()!=200);
        result=(creditCard.iaccount!=null);
        Assert.assertTrue(result.equals(expected));


    }

    @Test
    public void DepositFunds_AddingCashToAccount(){
        CreditCard creditCard=new CreditCard("1234");
        creditCard.AddAccount(new Account(100));
        creditCard.iaccount.DepositFunds(100);
        Assert.assertTrue(creditCard.iaccount.AccountStatus()==200);

        Double expected = 200d;
        Double result;
        result=creditCard.iaccount.AccountStatus();
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void WithdrawFunds_WithdrawingCashFromAccount(){
        CreditCard creditCard=new CreditCard("1234");
        creditCard.AddAccount(new Account(100));
        creditCard.iaccount.WithdrawFunds(50);
        Assert.assertTrue(creditCard.iaccount.AccountStatus()==50);

        Double expected = 50d;
        Double result;
        result=creditCard.iaccount.AccountStatus();
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void WithdrawFunds_CannotWithdrawMoreThanAccountHas(){
        CreditCard creditCard=new CreditCard("1234");
        creditCard.AddAccount(new Account(100));
        creditCard.iaccount.WithdrawFunds(150);
        Assert.assertTrue(creditCard.iaccount.AccountStatus()==100);

        Double expected = 100d;
        Double result;
        result=creditCard.iaccount.AccountStatus();
        Assert.assertTrue(result.equals(expected));
    }

}
