package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;
import com.uj.atm.interfaces.IAtm;
import com.uj.atm.interfaces.ICreditCard;

public class Atm implements IAtm {

   // public ICreditCard iCreditCard=null;

    public boolean CheckPinAndLogIn(ICreditCard creditCard, String pin){
        ICreditCard iCreditCard=creditCard;
        return iCreditCard.IsPinValid(pin);
    }

    public double AccountStatus(IAccount account){
        CreditCard creditCard=new CreditCard("1234");
        creditCard.AddAccount(account);
        return creditCard.iaccount.AccountStatus();
    }

    public boolean ChangePinCard(ICreditCard card, String oldPin, String newPin, String newPinConfirm){
        ICreditCard iCreditCard=card;
        if(iCreditCard.IsPinValid(oldPin)&&iCreditCard.IsPinValid(oldPin)&&iCreditCard.IsPinValid(newPin)&&iCreditCard.IsPinValid(newPinConfirm)){
            return iCreditCard.ChangePin(oldPin,newPin,newPinConfirm);
        }
        return false;
    }

    public boolean DepositFunds(ICreditCard card, double amount){
        ICreditCard iCreditCard=card;
        if(iCreditCard==null){
            System.out.println("no card assigned to account");
            return false;
        }
        iCreditCard.DepositFunds(amount);
        return true;
    }

    public boolean WithdrawFunds(ICreditCard card, double amount){
        ICreditCard iCreditCard=card;
        if(iCreditCard==null){
            System.out.println("no card assigned to account");
            return false;
        }
        iCreditCard.WithdrawFunds(amount);
        return true;
    }

    public boolean Transfer(ICreditCard card, IAccount accountRecipient, double amount){
        ICreditCard iCreditCard=card;
        if(iCreditCard==null||accountRecipient==null){
            System.out.println("no cards assigned to account");
            return false;
        }
        iCreditCard.WithdrawFunds(amount);
        accountRecipient.DepositFunds(amount);
        return true;
    }


}
