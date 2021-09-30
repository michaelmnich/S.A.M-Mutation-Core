package com.uj.atm.common;
import com.uj.atm.interfaces.IAccount;

public class Account implements IAccount {


    private double saldo = 0;

    /**
     * Zwraca bieżące saldo konta
     * Przykład: dla konta z saldem 384.34 metoda powinna zwrócić wartość 384.34
     * @return wartość liczbowa typu double określająca saldo konta
     */
    @Override
    public double AccountStatus() {
        return this.saldo;
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
        if(amount > 0) {
            this.saldo = this.saldo + amount;
        }
       return this.saldo;
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

        if(this.saldo >= amount && amount > 0 ) {
            this.saldo = this.saldo - amount ;
        }
        return this.saldo;
    }
}
