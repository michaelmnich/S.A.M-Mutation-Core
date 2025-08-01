package com.uj.atm.Bank;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {

    public String pin;
    Account accountCard = new Account();

    public CreditCard() { }

    public CreditCard(String Pin)
    {
        this.pin = Pin;
    }
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        boolean ChangedPin = false;
        try {
            if (this.pin.equals(oldPin)) {
                if(newPin.toCharArray().length !=4) throw new IllegalArgumentException("Pin musi zawierać 4 cyfry.");
                for (char c : newPin.toCharArray())
                {
                    if (!Character.isDigit(c)) throw new IllegalArgumentException("Pin zawiera niedozwolone znaki.");
                }
                if(newPin.equals(newPinConfirm))
                {
                    this.pin = newPin;
                }else{
                    throw new IllegalArgumentException("Nowy pin i potwierdzony pin nie są sobie równe.");
                }
            }else{
                throw new IllegalArgumentException("Podano nieprawidłowy pin do karty.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }finally {
            if(this.pin.equals(newPin))
                ChangedPin = true;
        }
        return ChangedPin;
    }

    @Override
    public boolean IsPinValid(String pin) {
        boolean CheckPin = false;
        try{
            if(this.pin.equals(pin)){
                CheckPin = true;
            }
            else{throw new IllegalArgumentException("Błędny pin.");}
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return CheckPin;
    }

    @Override
    public void AddAccount(IAccount account) {
        try
        {
            accountCard = (Account) account;
            if(accountCard.balance != account.AccountStatus()) throw new Exception("Nie udało się powiązać konta z kartą.");
        }
        catch (Exception ex) { System.out.println(ex.getMessage()); }
    }
    @Override
    public boolean DepositFunds(double amount)
    {
        boolean flag = false;
        try{
            if (amount <= 0.0) throw new Exception("Nie można wpłacić podanej kwoty.");
            else {
                accountCard.balance += amount;
                flag = true;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return flag;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        boolean flag = false;
        try{
            if (amount <= 0.0 || accountCard.balance < amount) throw new Exception("Nie można wypłacić podanej kwoty.");
            else {
                accountCard.balance -= amount;
                flag = true;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return flag;
    }
}
