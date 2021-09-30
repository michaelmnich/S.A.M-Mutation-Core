package com.uj.atm.Test;


import com.uj.atm.Account;
import com.uj.atm.CreditCard;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreditCardTest {


    /**
     * IsPinValid() - test sprawdzający czy podany jest poprawny według założonych reguł
     * (musi mieć równo 4 znaki i jest taki sam jak aktualny) - test z rezultatem pozytywnym
     */

    @Test
    public void test01() {
        ICreditCard creditCard = new CreditCard(0000);
        boolean result = creditCard.IsPinValid("0000");

        assertTrue(result);
    }

    /**
     * IsPinValid() - test sprawdzający czy podany jest poprawny według założonych reguł
     * (musi mieć równo 4 znaki i jest taki sam jak aktualny) - test z rezultatem negatywnym (jak pin podaliśmy null czyli pustą wartość)
     */

    @Test
    public void test02() {
        ICreditCard creditCard = new CreditCard(0000);

        boolean result = creditCard.IsPinValid(null);

        assertFalse(result);
    }

    /**
     * IsPinValid() - test sprawdzający czy podany jest poprawny według założonych reguł
     * (musi mieć równo 4 znaki i jest taki sam jak aktualny) - test z rezultatem negatywnym
     * (sprawdzamy pin 1234 natomiast aktualny na koncie mamy 0000 - nie są takie same)
     */

    @Test
    public void test03() {
        ICreditCard creditCard = new CreditCard(0000);
        boolean result = creditCard.IsPinValid("1234");

        assertFalse(result);
    }

    /**
     * AddAccount() - test dodający do naszej kart nowe konto (tworzymy nowy obiekt IAccount
     * i przypisujemy go do zmiennej w obiekcie public IAccount account;)
     */

    @Test
    public void test04() {
        ICreditCard creditCard = new CreditCard(0000);
        IAccount account = new Account(2000);

         creditCard.AddAccount(account);
    }

    /**
     * DepositFunds() - test sprawdzajaący poprawność dodania do naszego salda podaną kwotę
     * (test z rezultatem pozytywnym)
     */

    @Test
    public void test05() {
        ICreditCard creditCard = new CreditCard(0000);
        IAccount account = new Account(2000);
        creditCard.AddAccount(account);

        boolean result = creditCard.DepositFunds(50);

        assertTrue(result);
    }

    /**
     * DepositFunds() - test sprawdzajaący poprawność dodania do naszego salda podaną kwotę
     * lecz kwota jest mniejsza od 0 dlatego nic się nie doda
     * (test z rezultatem negatywnym)
     */

    @Test
    public void test06() {
        ICreditCard creditCard = new CreditCard(0000);
        IAccount account = new Account(2000);
        creditCard.AddAccount(account);

        boolean result = creditCard.DepositFunds(0);

        assertFalse(result);
    }

    /**
     * DepositFunds() - test sprawdzajaący poprawność dodania do naszego salda podaną kwotę
     * lecz nie mamy przypisanego konta do karty (świadczy o tym linijka creditCard.AddAccount(null);)
     * (test z rezultatem negatywnym)
     */

    @Test
    public void test07() {
        ICreditCard creditCard = new CreditCard(0000);
        creditCard.AddAccount(null);

        boolean result = creditCard.DepositFunds(0);

        assertFalse(result);
    }

    /**
     * WithdrawFunds() - test sprawdzający poprawność wypłacaenia pieniędzy z konta - test z rezultatem pozytywnym
     */

    @Test
    public void test08() {
        ICreditCard creditCard = new CreditCard(0000);
        IAccount account = new Account(2000);
        creditCard.AddAccount(account);

        boolean result = creditCard.WithdrawFunds(500);

        assertTrue(result);
    }

    /**
     * WithdrawFunds() - test sprawdzający poprawność wypłacaenia pieniędzy z konta lecz do naszej karty
     * nie jest przypisane żadne konto (świadczy o tym linijka         creditCard.AddAccount(null);)
     * - test z rezultatem negatywnym
     */

    @Test
    public void test09() {
        ICreditCard creditCard = new CreditCard(0000);
        creditCard.AddAccount(null);

        boolean result = creditCard.WithdrawFunds(500);

        assertFalse(result);
    }

    /**
     * ChangePin() - test sprawdzajacy poprawność zmiany PINu naszej karty, wszystkie warunki zostaną
     * spełnione ponieważ nowy pin jest prawidłowe a nowe są takie same więc pin zostanie zmieniony -
     * test z rezultatem pozytywnym
     */

    @Test
    public void test10() {
        ICreditCard creditCard = new CreditCard(0000);

        String oldPin = "0000";
        String newPin = "1234";
        String newPinConfirm = "1234";

        boolean result = creditCard.ChangePin(oldPin, newPin, newPinConfirm);

        assertTrue(result);
    }
}
