package com.uj.atm.Test;

import com.uj.atm.Account;
import com.uj.atm.interfaces.IAccount;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccountTest {

    /**
     * DepositFunds() - test sprawdzający czy prawidłowo zostanie dopisana kwota do naszego konta
     */

    @Test
    public void test01() {
        IAccount account = new Account(2000.0);
        double expected = 2050.0;
        double result = account.DepositFunds(50.0);

        assertThat(expected, equalTo(result));
    }

    /**
     * DepositFunds() - test sprawdzający czy prawidłowo zostanie dopisana kwota do
     * naszego konta lecz kwota jest = 0 dlatego zostanie zwrócona aktualnie saldo na koncie
     */

    @Test
    public void test02() {
        IAccount account = new Account(2000.0);
        double expected = 2000.0;
        double result = account.DepositFunds(0);

        assertThat(expected, equalTo(result));
    }

    /**
     * WithdrawFunds() - test sprawdzający czy zostanie z naszego konta odjęta prawidłowa suma
     * (w tym przypadku 600 zł)
     */

    @Test
    public void test03() {
        IAccount account = new Account(3000);
        double expected = 2400;
        double result = account.WithdrawFunds(600);

        assertThat(expected, equalTo(result));
    }
    /**
     * WithdrawFunds() - test sprawdzający czy zostanie z naszego konta odjęta prawidłowa suma
     * lecz podajemy 0 dlatego nic nie zostanie odjęte i zostanie zwrócone aktualne saldo na koncie
     */


    @Test
    public void test04() {
        IAccount account = new Account(3000);
        double expected = 3000;
        double result = account.WithdrawFunds(0);

        assertThat(expected, equalTo(result));
    }

    /**
     * AccountStatus() - test zwracający aktualne saldo na koncie
     */

    @Test
    public void test05() {
        IAccount account = new Account(3000);
        double expected = 3000;
        double result = account.AccountStatus();

        assertThat(expected, equalTo(result));
    }

}
