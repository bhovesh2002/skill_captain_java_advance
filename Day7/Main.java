package Day7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of seats: ");
        int num = sc.nextInt();
        Theatre theatre = new Theatre(num);

        Thread.sleep(2000);

        //books all seats with numbers divisible by 3
        Thread thread0 = new Thread(() -> {
            int i;
            for (i=1;i<=num; i++){
                if(i % 3 == 0){
                    theatre.bookSeat(i);
                }
            }
        });

        //books all seats with numbers divisible by 5
        Thread thread1 = new Thread(() -> {
            int i;
            for (i=1;i<=num; i++){
                if(i % 5 == 0){
                    theatre.bookSeat(i);
                }
            }
        });

        thread0.start();
        thread1.start();

        try {
            thread0.join();
            thread1.join();
        }catch (InterruptedException ie){
            System.out.println(ie);
        }

        theatre.printSeats();
    }
}
