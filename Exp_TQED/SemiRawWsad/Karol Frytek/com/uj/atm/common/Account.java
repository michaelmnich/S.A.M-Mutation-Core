package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {
    double money = 0;

@Override
public double AccountStatus(){
return money;
}
@Override
public double DepositFunds(double amount){
if(amount>0){
    money=money+amount;
}
return money;
}
@Override
public double WithdrawFunds(double amount){
    if(money-amount>0 && amount>0){
        money=money-amount;
    }
    return money;
}


}
