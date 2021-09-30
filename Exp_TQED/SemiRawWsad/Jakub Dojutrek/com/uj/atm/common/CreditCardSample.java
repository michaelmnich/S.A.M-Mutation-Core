package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardSample implements ICreditCard {

    private String regex4 = "^[0-9]{4}$";
    private String regex6 = "^[0-9]{6}$";
    private Pattern p1 = Pattern.compile(regex4);
    private Pattern p2 = Pattern.compile(regex6);
    private IAccount iaccount = null;

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {
        Matcher m1 = p1.matcher(newPin);
        Matcher m2 = p2.matcher(newPin);

        if (newPin.isEmpty() || newPinConfirm.isEmpty()){
            return false;
        }else if (!oldPin.equals(newPin) && newPin.equals(newPinConfirm)){
            return (m1.matches() || m2.matches());
        }
        else return false;

    }

    @Override
    public boolean IsPinValid(String pin) {
        Matcher m1 = p1.matcher(pin);
        Matcher m2 = p2.matcher(pin);

        if (pin.isEmpty() || pin.isBlank())
            return false;
        else return m1.matches() || m2.matches();
    }

    @Override
    public void AddAccount(IAccount account) {
        if (iaccount == null)
            this.iaccount = account;
    }

    @Override
    public boolean DepositFunds(double amount) {
        if (iaccount != null){
            iaccount.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if (iaccount != null && amount > 0.0 && iaccount.AccountStatus()-amount>0.0){
            iaccount.WithdrawFunds(amount);
            return true;
        }
        return false;
    }
}
