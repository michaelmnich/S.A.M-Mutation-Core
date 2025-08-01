package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;


public class CreditCard implements ICreditCard {
    private char[] pin;
    private IAccount ACCOUNT ;

    public CreditCard(Account account) {
        pin = new char[4];
        for (int i = 0; i < 4; i++) {
            pin[i] = '0';
        }
        ACCOUNT = account;
    }

    public CreditCard() {
        pin = new char[4];
        for (int i = 0; i < 4; i++) {
            pin[i] = '0';
        }
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        if (oldPin.equals(new String(pin))){

            if (newPin.equals(newPinConfirm) && newPin.length() == 4 ){

                char[] tabPin = newPin.toCharArray();

                for (int i = 0; i < 4 ; i++) {
                    if (47 < tabPin[i] && tabPin[i] < 58){
                        pin[i] = tabPin[i];
                    }
                    else {
                        return false;
                    }
                }

                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean IsPinValid(String pin) {
        if(pin.equals(new String(this.pin))){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void AddAccount(IAccount account) throws Exception {
            if (ACCOUNT == null ){
               ACCOUNT = account;
            }
            else {
                throw new Exception();
            }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (ACCOUNT != null){
            Double saldo = ACCOUNT.AccountStatus();
            if (ACCOUNT.DepositFunds(amount) != saldo){
                return true;
            }
            else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (ACCOUNT != null){
            Double saldo = ACCOUNT.AccountStatus();
            if (ACCOUNT.WithdrawFunds(amount) != saldo){
                return true;
            }
            else {
                return false;
            }
        }else {
            return false;
        }
    }
}
