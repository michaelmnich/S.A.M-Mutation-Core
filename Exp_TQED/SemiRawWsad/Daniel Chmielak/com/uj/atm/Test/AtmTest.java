package com.uj.atm.Test;

import com.uj.atm.Account;
import com.uj.atm.Atm;
import com.uj.atm.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AtmTest {

    /**
     * CheckPinAndLogIn() - test sprwdzający poprawność zalogowania się do naszego konta
     * pin musi być poprawny 1234 == 1234
     * - test z rezultatem pozytywnym
     */

    @Test
    public void test01() {
        Atm atm = new Atm();

        ICreditCard creditCard = new CreditCard(1234);

        boolean result = atm.CheckPinAndLogIn(creditCard, "1234");

        assertTrue(result);
    }

    /**
     * CheckPinAndLogIn() - test sprwdzający poprawność zalogowania się do naszego konta
     * lecz podany pin nie jest taki sam jak na naszej karcie 1234 != 5432
     * - test z rezultatem negatywnym
     */

    @Test
    public void test02() {
        Atm atm = new Atm();

        ICreditCard creditCard = new CreditCard(1234);

        boolean result = atm.CheckPinAndLogIn(creditCard, "5432");

        assertFalse(result);
    }

    /**
     * ChangePinCard() - test sprawdzający poprawność zmiany pinu do naszej karty, wsyzstkie warunki są spełnione
     * stary pin jest taki sam jak aktualnie na karcie oraz nowe piny są takie same zatem pin zostanie poprawnie zmieniony
     * - test z rezultatem pozytywnym
     */

    @Test
    public void test03() {
        Atm atm = new Atm();

        ICreditCard creditCard = new CreditCard(1234);
        String oldPin = "1234";
        String newPin = "4542";
        String newPinConfirm = "4542";

        boolean result = atm.ChangePinCard(creditCard, oldPin, newPin, newPinConfirm);

        assertTrue(result);
    }

    /**
     * ChangePinCard() - test sprawdzający poprawność zmiany pinu do naszej karty, nie wszsytkie watunki są spełnione
     * ponieważ stary pin nie jest taki sam jak aktualny przypisany do karty
     * - test z rezultatem negatywnym
     */

    @Test
    public void test04() {
        Atm atm = new Atm();

        ICreditCard creditCard = new CreditCard(1234);
        String oldPin = "6422";
        String newPin = "4542";
        String newPinConfirm = "4542";

        boolean result = atm.ChangePinCard(creditCard, oldPin, newPin, newPinConfirm);

        assertFalse(result);
    }

    /**
     * DepositFunds() - test sprawdzający poprawność wpłaty określonej sumy na nasze konto
     * - test zrezultatem pozytywnym
     */

    @Test
    public void test05() {
        Atm atm = new Atm();

        IAccount account = new Account(5000);
        ICreditCard creditCard = new CreditCard(1234);
        creditCard.AddAccount(account);

        double amount = 15;
        boolean result = atm.DepositFunds(creditCard, amount);

        assertTrue(result);
    }

    /**
     * WithdrawFunds() - test sprawdzający poprawność wypłacenia określonej sumy z naszego konta,
     * test z rezulatem pozytywnym (posiadamy odpowiednią ilość pieniędzy na koncie które chcemy wypłacić)
     */

    @Test
    public void test06() {
        Atm atm = new Atm();

        IAccount account = new Account(5000);
        ICreditCard creditCard = new CreditCard(1234);
        creditCard.AddAccount(account);

        double amount = 15;

        boolean result = atm.WithdrawFunds(creditCard, amount);

        assertTrue(result);
    }
    /**
     * WithdrawFunds() - test sprawdzający poprawność wypłacenia określonej sumy z naszego konta,
     * test z rezulatem negatywnym (nie posiadamy wystarczająco pieniędzy na koncie, chcemy wypłacić 15000
     * natomaist na koncie posiadamy tylko 1000)
     */


    @Test
    public void test07() {
        Atm atm = new Atm();

        IAccount account = new Account(1000);
        ICreditCard creditCard = new CreditCard(1234);
        creditCard.AddAccount(account);

        double amount = 15000;

        boolean result = atm.WithdrawFunds(creditCard, amount);

        assertFalse(result);
    }

    /**
     * Transfer()- test sprawdzający poprawność wykonanai transakcji na inne konto, test z rezultatem pozytywnym
     * (wszystie warunki są spełnione, posiadamy wystarczając pieniędzy oraz do karty jest przypisane konto)
     */

    @Test
    public void test08() {
        Atm atm = new Atm();

        IAccount account = new Account(5000);
        IAccount accountRecipient = new Account(1000);
        ICreditCard creditCard = new CreditCard(1234);
        creditCard.AddAccount(account);

        double amount = 100;

        boolean result = atm.Transfer(creditCard, accountRecipient, amount);

        assertTrue(result);
    }

}
