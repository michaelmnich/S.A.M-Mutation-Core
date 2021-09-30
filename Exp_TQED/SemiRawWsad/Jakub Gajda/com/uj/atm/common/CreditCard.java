package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;


public class CreditCard implements ICreditCard {
    String Pin="0000"; /** pin jako domyślny */
    IAccount BankAccount = null; /** wprowadzone konto */

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin == Pin && newPin != oldPin && newPin == newPinConfirm){
            Pin = newPin;
            return true;
        }
            else {
                return false;
            }
        }

    @Override
    public boolean IsPinValid(String pin) {
        if(Pin.equals(pin)) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) {
        BankAccount = account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(BankAccount!=null){
            BankAccount.DepositFunds(amount);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (BankAccount != null) {
            BankAccount.WithdrawFunds(amount);
            return true;
        } else {
            return false;
        }

    }
}

