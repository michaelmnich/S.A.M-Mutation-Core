package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

public class AccountBalance implements IAccount{

        public double saldo;
        @Override
        public double AccountStatus() {
            return saldo;
        }

        @Override
        public double DepositFunds(double amount) {
            if(amount > 0) {
                saldo += amount;
            }
            return saldo;
        }

        @Override
        public double WithdrawFunds(double amount) {
            if(amount < 0) {
                return saldo;
            }
            if(saldo >= amount) {
                saldo -= amount;
            }
            return saldo;
        }
}

