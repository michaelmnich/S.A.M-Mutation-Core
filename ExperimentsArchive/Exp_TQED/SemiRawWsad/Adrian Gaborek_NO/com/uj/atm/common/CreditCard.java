package com.uj.atm.common;
import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.ICreditCard;


public class CreditCard implements ICreditCard {

    private Integer pinNumber;
    public IAccount account;

    public CreditCard() {
        this.pinNumber = 0000;
    }

    @Override
    public boolean ChangePin(String oldPin, String newPin, String newPinConfirm) {

        if(IsPinValid(oldPin)) {
            if(IsPinInCorrectForm(newPin) && newPin.equals(newPinConfirm)) {
                pinNumber = Integer.parseUnsignedInt(newPin);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean IsPinValid(String pin) {
        try {
            if(pin.length() == 4 && !pin.contains("+")) {
                return Integer.parseUnsignedInt(pin) == pinNumber;
            }
        }

        catch (NumberFormatException | NullPointerException ex){
            return false;
        }

        return false;
    }

    @Override
    public void AddAccount(IAccount account){
        if(this.account == null) {
            this.account = account;
        }
    }

    @Override
    public boolean DepositFunds(double amount) {
        if(amount > 0 && account!= null) {
            account.DepositFunds(amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean WithdrawFunds(double amount) {
        if(amount > 0 && account != null && account.AccountStatus() >=amount) {
            account.WithdrawFunds(amount);
            return  true;
        }
        return false;
    }

    private boolean IsPinInCorrectForm (String pin) {
        try {
            if(pin.length() == 4 && !pin.contains("+")) {
                Integer.parseUnsignedInt(pin);
                return true;
            }
        }

        catch (NumberFormatException | NullPointerException ex){
            return false;
        }

        return false;
    }
}
