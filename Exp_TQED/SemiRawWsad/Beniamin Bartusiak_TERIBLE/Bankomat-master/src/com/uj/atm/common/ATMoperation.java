package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;


public class ATMoperation implements IAtm{
        @Override
        public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin) {
            if (creditCard.IsPinValid(pin)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public double AccountStatus(IAccount account) {
            return account.AccountStatus();
        }


        @Override
        public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm) {
            if (newPin == newPinConfirm) {
                card.ChangePin(oldPin, newPin, newPinConfirm);
                return true;
            }
            return false;
        }

        @Override
        public boolean DepositFunds(ICreditCard card, double amount) {
            if(amount > 0) {
                card.DepositFunds(amount);
                return true;
            }
            return false;
        }

        @Override
        public boolean WithdrawFunds(ICreditCard card, double amount) {
            if(amount > 0 ) {
                card.WithdrawFunds(amount);
                return true;
            }
            return false;
        }
        @Override
        public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount) {
            if(amount > 0) {
                if(card.WithdrawFunds(amount)) {
                    accountRecipient.DepositFunds(amount);
                    return true;
                }
            }
            return false;
        }
}

