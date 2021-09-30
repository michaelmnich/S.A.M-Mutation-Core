package com.uj.atm;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

import static java.lang.Math.abs;

public class Atm implements IAtm {

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        return creditCard.IsPinValid(pin);
    }

    @Override
    public double AccountStatus(IAccount account) {
        return account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if (card.IsPinValid(oldPin)) {
            try {
                Integer.parseInt(newPin);
                Integer.parseInt(newPinConfirm);
                if (newPin.equals(newPinConfirm) & newPin.length() == 4 & !oldPin.equals(newPin)) {
                    card.ChangePin(oldPin, newPin, newPinConfirm);
                    return true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Pin musi składać się z cyfr!");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if (amount > 0){
            return card.DepositFunds(amount);
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if (amount > 0){
            return card.WithdrawFunds(amount);
        }
        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        if(amount > 0) {
            if (card.WithdrawFunds(amount)) {
                accountRecipient.DepositFunds(amount);
                return true;
            }
        }
        return false;
    }
}
