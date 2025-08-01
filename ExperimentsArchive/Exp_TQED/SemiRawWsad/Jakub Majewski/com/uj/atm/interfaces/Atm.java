package com.uj.atm.interfaces;

import java.util.Objects;

public class Atm implements IAtm{
    String pinek = "5325";

    @Override
    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
        if (Objects.equals(pinek, pin)) {
            System.out.print("\nUdało sie kod wynosi : "+pin);

            return true;}
        else{;
            return false;
        }
    }

    @Override
    public double AccountStatus(IAccount account) {

        return account.AccountStatus();
    }


    @Override
    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {

        return true;
    }

    @Override
    public boolean DepositFunds(ICreditCard card, double amount) {

        return false;
    }

    @Override
    public boolean WithdrawFunds(ICreditCard card, double amount) {

        return false;
    }

    @Override
    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {

        return false;
    }
}
