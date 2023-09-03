package Day6;

public class BankAccount {

    protected int balance;

    public BankAccount(int initialAmount){
        balance = initialAmount;
    }

    public void deposit(int amount){
        balance = balance + amount;
    }

    public void withdraw(int amount){
        balance = balance - amount;
    }

    public int getBalance() {
        return balance;
    }
}
