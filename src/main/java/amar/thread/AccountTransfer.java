package amar.thread;

import java.util.Random;

/**
 * Created by amarendra on 17/09/17.
 */
public class AccountTransfer {
    public static void main(final String[] args) throws InterruptedException {

        final AccountRunner accountRunner = new AccountRunner();

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                accountRunner.firstThread();
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                accountRunner.secondThread();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        accountRunner.finish();
    }

}

class AccountRunner {

    private Account account1 = new Account();
    private Account account2 = new Account();

    public void firstThread() {
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Account.transfer(account1, account2, random.nextInt(100));
        }
    }

    public void secondThread() {
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Account.transfer(account2, account1, random.nextInt(100));
        }
    }

    public void finish() {
        System.out.println("Account1 : " + account1);
        System.out.println("Account2 : " + account2);
        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }

}

class Account {
    private int balance = 10000;

    public static void transfer(final Account account1, final Account account2, final int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }

    public void deposit(final int amount) {
        balance = balance + amount;
    }

    public void withdraw(final int amount) {
        balance = balance - amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
