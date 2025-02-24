package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static final int ID_USER_1 = 1;
    public static final int INITIAL_MONEY = 0;
    public static final int AMOUNT_100_MONEY = 100;
    public static final int AMOUNT_30_MONEY = 30;
    public static final int AMOUNT_80_MONEY = 80;

    public static void main(String[] args) {
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", ID_USER_1);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, INITIAL_MONEY);
        bankAccount.deposit(accountHolder.getId(), AMOUNT_100_MONEY);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), AMOUNT_30_MONEY);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), AMOUNT_80_MONEY);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
