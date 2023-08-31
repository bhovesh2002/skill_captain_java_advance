package Day1;

public class PrintNumbers {

    public static void main(String[] args) {
        Thread thread1 = new NewThread(3);
        Thread thread2 = new NewThread(4);

        thread1.start();
        thread2.start();
    }

}
