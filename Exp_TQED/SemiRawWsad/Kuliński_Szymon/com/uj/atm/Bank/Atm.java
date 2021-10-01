package com.uj.atm.Bank;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm{


    CreditCard visaCard = new CreditCard();
    Account accountTmp = new Account();

    public Atm() { }

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin)
    {
        visaCard = (CreditCard) creditCard;
        boolean flag = false;
        try{
            if(pin.equals(visaCard.pin)) flag = true;
            else throw new Exception("Pin niepoprawny.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return flag;
    }

    @Override
    public double AccountStatus(IAccount account) {
        accountTmp = (Account) account;
        return accountTmp.balance;
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        visaCard = (CreditCard) card;
        boolean ChangedPin = false;
        try {
            if (visaCard.pin.equals(oldPin)) {
                if(newPin.toCharArray().length !=4) throw new IllegalArgumentException("Pin musi zawierać 4 cyfry.");
                for (char c : newPin.toCharArray())
                {
                    if (!Character.isDigit(c)) throw new IllegalArgumentException("Kod pin zawiera niedozwolone znaki.");
                }
                if(newPin.equals(newPinConfirm))
                {
                    visaCard.pin = newPin;
                }else{
                    throw new IllegalArgumentException("Nowy pin i potwierdzony pin są od siebie różne.");
                }
            }else{
                throw new IllegalArgumentException("Podano zły pin do karty.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }finally {
            if(visaCard.pin.equals(newPin))
                ChangedPin = true;
        }
        return ChangedPin;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount)
    {
        boolean flag = false;
        visaCard = (CreditCard) card;
        try{
            if (amount <= 0.0) throw new Exception("Nie można wpłacić podanej kwoty.");
            else {
                visaCard.accountCard.balance += amount;
                flag = true;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return flag;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount)
    {
        boolean flag = false;
        visaCard = (CreditCard) card;
        try{
            if (amount <= 0.0 || visaCard.accountCard.balance < amount) throw new Exception("Nie można wpłacić podanej kwoty.");
            else {
                visaCard.accountCard.balance -= amount;
                flag = true;
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        return flag;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount)
    {
        visaCard = (CreditCard) card;
        accountTmp = (Account) accountRecipient;
        boolean flag = false;
        try
        {
            if(visaCard.accountCard.balance < amount) throw new Exception("Niewystarczające środki na koncie.");
            else {
                visaCard.accountCard.balance -=amount;
                accountTmp.balance +=amount;
                flag = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
