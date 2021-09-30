package com.uj.atm.common;

import com.uj.atm.interfaces.IAccount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements IAccount {
    double balance = 0;

    /**
     * Zwraca bieżące saldo konta
     * Przykład: dla konta z saldem 384.34 metoda powinna zwrócić wartość 384.34
     * @return wartość liczbowa typu double określająca saldo konta
     */
    @Override
    public double AccountStatus() {
        return this.balance;
    }

    /**
     * Metoda realizuje wpłatę na konto
     * Po jej wykonaniu wartość środków na koncie powinna zwiększyć
     się o wartość amount
     * Przykład: jeśli na koncie jest 100 PLN to wykonanie DepositFunds(50)
     * powinno skutkować zwiększeniem środków na koncie na rzecz którego wykonano metodę o kwotę 50 PLN i końcowym saldem 150 PLN.
     * @param amount Dodatnia kwota do wpłacenia na konto.
     * @return Saldo konta po dokonaniu operacji wpłacenia na konto.
     */
    @Override
    public double DepositFunds(double amount) {
        BigDecimal balance = new BigDecimal(this.balance);
        BigDecimal newAmount = new BigDecimal(amount);

        if (amount > 0) {
            BigDecimal sum = balance.add(newAmount);
            this.balance = sum.setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return this.balance;
    }

    /**
     * Metoda realizuje wypłatę środków z konta.
     * Po jej wykonaniu wartość środków na koncie powinna zmniejszyć się o wartość amount
     * Przykład: dla konta z saldem 450 PLN wykonanie WithdrawFunds(50) dla konta,
     * na rzecz którego wykonano tę metodę powinna skutkować wypłatą 50 PLN i końcowym saldem 400 PLN.
     * @param amount Dodatnia kwota do wypłacenia z konta.
     * @return Saldo na koncie po wykonaniu operacji wypłaty.
     */
    @Override
    public double WithdrawFunds(double amount) {
        BigDecimal balance = new BigDecimal(this.balance);
        BigDecimal newAmount = new BigDecimal(amount);
        BigDecimal subtract = balance.subtract(newAmount);
        double tmp = subtract.setScale(2, RoundingMode.HALF_UP).doubleValue();

        if (amount > 0 && tmp >= 0) {
            this.balance = tmp;
        }
        return this.balance;
    }

}
