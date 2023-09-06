package Day8;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class Main {

    //just so that I can keep something as key for the map
    private static int id = 1;

    //creates an empty hashmap
    private static ThreadLocal<Map<Integer, Day8.UserData>> threadLocalMap = new ThreadLocal<>(){
        @Override
        protected Map<Integer, Day8.UserData> initialValue(){
            Map<Integer, Day8.UserData> info = new HashMap<>();
            return info;
        }
    };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //creates 5 threads and calls instantiate and then print the details
        for(int i = 1; i<5 ; i++){
            Thread thread = new Thread(() -> {
                try {
                    instantiate(sc);

                    printDetails(threadLocalMap.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            sc.close();
        }
    }

    //gets the threadLocalMap and then creates a separate map for each thread which only contains 1 key and value
    public static void instantiate(Scanner sc) throws InputMismatchException, InterruptedException {
        Map<Integer, Day8.UserData> info = threadLocalMap.get();
        System.out.println("Entering username ... ");
        String username = "Name: "+Thread.currentThread().getName();
        System.out.println("Entering password ... ");
        String password = "password: "+Thread.currentThread().getName();

        int min = 1;
        int max = 10;
        int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        int total = random*1000;
        Thread.sleep(total);
        int currentId = id;

        info.put(currentId, new Day8.UserData(username, password, total));
        threadLocalMap.set(info);
    }

    //prints details of each map by calling function from userData class
    public static void printDetails(Map<Integer, Day8.UserData> infoMap){
        System.out.println("---- print -----");
        infoMap.get(1).getDetails();
    }

}
