package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.util.regex.Pattern;

public class CreditCard implements ICreditCard {
    String pin = "0000";
    IAccount owner;

    /**
     * Metoda zmienia PIN karty i zwraca true w przypadku poprawnej zmiany kodu PIN oraz false w przypadku nieudanej zmiany.
     * @param oldPin Stary PIN
     * @param newPin Nowy PIN
     * @param newPinConfirm Nowy PIN - wartość weryfikująca: newPin oraz newPinConfirm muszą być sobie równe.
     * @return Jeżeli uda się zmienić kod PIN, zwraca true. W przeciwnym razie zwraca false
     */
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        boolean test = Pattern.matches("(\\d{4})", newPin);

        if (newPin == newPinConfirm && test == true) {
            this.pin = newPinConfirm;
            return true;
        }
        return false;
    }

    /**
     * Metoda sprawdza, czy PIN danej karty jest poprawny
     * @param pin Kod PIN zapisany jako łańcuch znakowy (String)
     * @return Jeżeli kod PIN jest poprawny zwraca true, w przeciwnym wypadku zwraca false.
     */
    @Override
    public boolean IsPinValid(String pin) {
        if ( this.pin == pin) {
            return true;
        }
        return false;
    }

    /**
     * Metoda stowarzysza z daną kartą określone konto. Każda karta może być stowarzyszona z co najwyżej jednym kontem.
     * @param account Obiekt konta które będzie dodane do karty.
     */
    @Override
    public void AddAccount(IAccount account) {
        if (this.owner == null) {
            this.owner = account;
        }
    }

    /**
     * Metoda realizuje wpłatę pieniędzy na konto stowarzyszone z tą kartą
     * @param amount Kwota jaką chcemy wpłacić
     * @return Zwraca true lub false w zależności od tego,
     * czy operacja się uda (może się nie udać jeśli na przykład obiekt konta dla danej karty jest = null).
     */
    @Override
    public boolean DepositFunds(double amount) {
        if (this.owner != null && amount > 0) {
            this.owner.DepositFunds(amount);
            return true;
        }
        return false;
    }

    /**
     * Metoda realizuje wypłatę określonej kwoty z konta stowarzyszonego z daną kartą.
     * @param amount Kwota jaką chcemy wypłacić
     * @return Zwraca true lub false w zależności od tego, czy operacja się uda.
     */
    @Override
    public boolean WithdrawFunds(double amount) {
        if (amount > 0 && this.owner != null && this.owner.AccountStatus() >= amount) {
            this.owner.WithdrawFunds(amount);
            return true;
        }
        return false;
    }

}
