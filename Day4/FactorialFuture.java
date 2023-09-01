package Day4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialFuture {

    public static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private int num;

    public FactorialFuture(int num){
        this.num = num;
    }

    //How do I make this method return a long value? When I change the return type to Future<Long> and change fact to long too, it gives an error.
    //I even tried replacing int with long everywhere, but it didn't work.
    public Future<Integer> calFactorial(){
        return executorService.submit(() -> {
           if (num < 0) {
               System.out.println("Number cannot be negative!");
               return 0;

           }else if(num == 0) {
               return 1;
           }else {
               int fact = 1;
               int currentNum = 1;
               while (currentNum <= num) {
                   fact = fact * currentNum;
                   currentNum++;
               }
               return fact;
           }
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter any number: ");
            int num = sc.nextInt();
            Future<Integer> future = new FactorialFuture(num).calFactorial();

            System.out.println("Currently in: " + Thread.currentThread().getName());
            System.out.println("Calculation in Progress...");

            int result = future.get();
            System.out.println("The factorial is: " + result);

            executorService.shutdown();
        }catch (InputMismatchException | InterruptedException |ExecutionException e){
            System.out.println(e);
        }

    }

}
