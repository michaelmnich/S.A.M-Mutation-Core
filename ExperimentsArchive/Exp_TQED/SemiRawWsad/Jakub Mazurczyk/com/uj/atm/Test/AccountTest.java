package com.uj.atm.Test;

import com.uj.atm.common.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Assert;
import org.junit.Test;


public class AccountTest {
    @Test
    public void test01(){

        IAccount konto = new Account();
        double status = konto.AccountStatus();
        if(konto.WithdrawFunds(50)-status<0){// sprawdzamy czy z pustego konta mozemy wyciagnac pieniadze
            System.out.println("Udalo sie");

        } else {
            System.out.println("Operacja się nie powiodla");
        }
        konto.DepositFunds(999999959);
        status = konto.AccountStatus();
        System.out.println("twoje środki na koncie: "+status);
        status = konto.WithdrawFunds(59);

        Assert.assertEquals(999999900,status,0);
    }
}

