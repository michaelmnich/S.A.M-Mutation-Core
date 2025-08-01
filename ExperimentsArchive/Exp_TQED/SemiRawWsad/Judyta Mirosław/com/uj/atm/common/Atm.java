package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {
    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if(pin.matches("\\d{4}") && pin.equals(creditCard.getPIN()))
            return true;
        return false;
    }

    @Override
    public double AccountStatus(IAccount account) {
        return account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if(oldPin.matches("\\d{4}") && newPin.matches("\\d{4}") && newPinConfirm.matches("\\d{4}")
                && card.getPIN() == oldPin) {
            if(newPin == newPinConfirm) {
                card.setPIN(newPin);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        if(card.isStowarzyszona()) {
            if(card.DepositFunds(amount))
                return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        if(card.isStowarzyszona()) {
            if(card.WithdrawFunds(amount))
                return true;
        }
        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount){
        if(card.isStowarzyszona()) {
            if (card.getAccount().AccountStatus() > amount) {
                double accountRecipienStatus = accountRecipient.AccountStatus();
                if (WithdrawFunds(card, amount) &&
                        (accountRecipient.DepositFunds(amount) == (accountRecipienStatus + amount)))
                    return true;
            }
        }
        return false;
    }
}
