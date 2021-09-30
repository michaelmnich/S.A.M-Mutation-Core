package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class ATMSample implements IAtm {
    String pin = "0000";
    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        return this.pin.equals(pin);

    }

    @Override
    public double AccountStatus(IAccount account) {
        return account.AccountStatus();
    }

    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
        if (newPin.equals(newPinConfirm))
            pin = newPin;
        return card.ChangePin(oldPin, newPin, newPinConfirm);
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {
        return card.DepositFunds(amount);
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {
        return card.WithdrawFunds(amount);
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
        //???????????? Nie rozumiem czy tu chodzi o Transfer konta i jego stanu, czy transfer w stylu przelewu kwoty

        if(card.WithdrawFunds(amount)) {
            accountRecipient.DepositFunds(amount);
            return true;
        }
        return false;
    }
}
