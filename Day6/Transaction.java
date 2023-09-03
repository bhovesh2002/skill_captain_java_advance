package Day6;

//since the program doesn't ask user to enter amount, there's no error handling.
//I though letting the user choose the command and then deposit/withdraw would make the lock useless?
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transaction {
    private static BankAccount bankAccount = new BankAccount(1000);
    private static Lock lock = new ReentrantLock();

    public void operation(int amount, char choice){
        lock.lock();

        if(choice == 'w'){
            bankAccount.withdraw(amount);
            System.out.println(Thread.currentThread().getName()+ ": Withdraw "+ amount );
        }else if(choice == 'd'){
            bankAccount.deposit(amount);
            System.out.println(Thread.currentThread().getName()+ ": Deposit "+ amount );
        }

        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Transaction transaction = new Transaction();
        System.out.println("Initial Balance: " + bankAccount.getBalance() );
        Thread thread1 = new Thread(() -> transaction.operation(5000, 'd'));
        Thread thread2 = new Thread(() -> transaction.operation(2000, 'w'));
        Thread thread3 = new Thread(() -> transaction.operation(3000, 'w'));
        Thread thread4 = new Thread(() -> transaction.operation(2000, 'd'));
        Thread thread5 = new Thread(() -> transaction.operation(5000, 'd'));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        Thread.sleep(5000);
        System.out.println("Final Balance: " + bankAccount.getBalance() );
    }
}
