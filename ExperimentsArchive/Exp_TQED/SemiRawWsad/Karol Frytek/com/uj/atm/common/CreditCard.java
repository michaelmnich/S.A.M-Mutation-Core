package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.util.Objects;

public class CreditCard implements ICreditCard {
String Pin = "0000";
IAccount BankAccount = null;
    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        int i;
        if(newPin.length()==4){
            for(i=0;i<4;i++){
                if(Character.isDigit(newPin.charAt(i))){
                    if(i<3){
                    }else if(i==3){
                        if(oldPin == Pin && newPin !=oldPin && newPin == newPinConfirm ){
                            Pin = newPin;
                            return true;
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {

        int i;
        if(pin.length()==4){
            for(i=0;i<4;i++){
                if(Character.isDigit(pin.charAt(i))){
                    if(i<3){
                    }else if(i==3){
                            if(Objects.equals(pin, Pin)){
                                return true;
                            }else{
                                return false;
                            }
                    }else{
                        return false;
                    }

                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
       return false;
    }

    @Override
    public void AddAccount(IAccount account) {
        if(BankAccount==null){
            BankAccount = account;
        }
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
        if(BankAccount!=null){
            BankAccount.WithdrawFunds(amount);
            return true;
        }else{
            return false;
        }

    }
}
