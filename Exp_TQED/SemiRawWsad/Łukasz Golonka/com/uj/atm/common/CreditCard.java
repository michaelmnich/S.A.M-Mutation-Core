package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

public class CreditCard implements ICreditCard {
    private  String pin = "0000";
    private IAccount associatedAccount = null;

    @Override
    public boolean IsPinValid(String pin) {
        return (pin.length() == 4 && pin.matches("[0-9]+"));
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if ( this.pin.equals(oldPin) && newPin.equals(newPinConfirm) && IsPinValid(newPin)){
            this.pin = newPin;
            return  true;
        }
        return  false;
    }

    @Override
    public void AddAccount(IAccount account) {
        if (this.associatedAccount == null){
            this.associatedAccount = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (this.associatedAccount == null){
            return   false;
        }
        else {
            this.associatedAccount.DepositFunds(amount);
            return  true;
        }
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (this.associatedAccount == null){
            return  false;
        }
        try {
            double  initialBalance = this.associatedAccount.AccountStatus();
            double amountAfterWithdrawal = this.associatedAccount.WithdrawFunds(amount);
            return (amountAfterWithdrawal + amount) == initialBalance;
        }
        catch (IllegalArgumentException e){
            return  false;
        }
    }
}
