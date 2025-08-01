package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    private String pin = "0000";
    private IAccount acc = null;
    /**
     * Metoda zmienia PIN karty i zwraca true w przypadku poprawnej zmiany kodu PIN oraz false w przypadku nieudanej zmiany.
     * @param oldPin Stary PIN
     * @param newPin Nowy PIN
     * @param newPinConfirm Nowy PIN - wartość weryfikująca: newPin oraz newPinConfirm muszą być sobie równe.
     * @return Jeżeli uda się zmienić kod PIN, zwraca true. W przeciwnym razie zwraca false
     */
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if(oldPin.length() == 4 && newPin.length() == 4 && newPinConfirm.length() == 4) {
            try
            {
                Integer.parseInt(oldPin);
                Integer.parseInt(newPin);
                Integer.parseInt(newPinConfirm);

                char ch1 = newPin.charAt(0);
                char ch2 = newPin.charAt(0);
                char ch3 = newPin.charAt(0);
                char ch4 = newPin.charAt(0);


                if (oldPin.equals(this.pin) && newPin.equals((newPinConfirm)) && ch1!='-' && ch2!='-' && ch3!='-' && ch4!='-' ) {
                    this.pin = newPin;
                    return true;
                }
                else return false;
            }
            catch(NumberFormatException e)
            {
                return false;
            }

        }
        else return false;
    }
    /**
     * Metoda sprawdza, czy PIN danej karty jest poprawny
     * @param pin Kod PIN zapisany jako łańcuch znakowy (String)
     * @return Jeżeli kod PIN jest poprawny zwraca true, w przeciwnym wypadku zwraca false.
     */
    @Override
    public boolean IsPinValid(String pin) {
        if(pin.length() == 4)
        {
            try {
                Integer.parseInt(pin);
                Integer test = Integer.parseInt(pin);
                if(pin.equals(this.pin) && test >= 0 ) return true;
                else return false;
            } catch(NumberFormatException e){
                return false;
            }
        }
        return false;
    }
    /**
     * Metoda stowarzysza z daną kartą określone konto. Każda karta może być stowarzyszona z co najwyżej jednym kontem.
     * @param account Obiekt konta które będzie dodane do karty.
     */
    @Override
    public void AddAccount(IAccount account) {
        if(this.acc == null) {
            this.acc = account;
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
        if(acc != null && amount > 0)
        {
            double saldo = acc.AccountStatus();
            acc.DepositFunds(amount);

            if(acc.AccountStatus() == saldo + amount){
                return true;
            }
            else return false;

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
        if(acc != null && amount >= 0)
        {
            double saldo = acc.AccountStatus();
            if(saldo >= amount)
            {
                acc.WithdrawFunds(amount);

                if(acc.AccountStatus() == saldo - amount){
                    return true;
                }
                else return false;

            }
        }
        return false;
    }
}
