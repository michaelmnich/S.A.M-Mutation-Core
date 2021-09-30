package com.uj.atm;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    String pin;
    IAccount account = null;

    public CreditCard(String pin) {
        try {
            Integer.parseInt(pin);
            if (pin.length() == 4) this.pin = pin;
        }catch (NumberFormatException nfe) {
            System.out.println("Pin musi składać się z cyfr!");
        }
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin.equals(this.pin)) {
            try {
                Integer.parseInt(newPin);
                Integer.parseInt(newPinConfirm);
                if (newPin.equals(newPinConfirm) & newPin.length() == 4 & !oldPin.equals(newPin)) {
                        this.pin = newPin;
                        return true;
                    } else {
                        return false;
                    }
            }catch (NumberFormatException nfe){
                System.out.println("Pin musi składać się z cyfr!");
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        try {
            return this.pin.equals(pin);
        } catch (NullPointerException e){
            System.out.println("Brak karty!");
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.account == null){
            this.account = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.account != null & amount > 0){
            this.account.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.account != null & amount > 0){
            if (this.account.AccountStatus() >= amount){
                this.account.WithdrawFunds(amount);
                return true;
            }
        }
        return false;
    }
}
