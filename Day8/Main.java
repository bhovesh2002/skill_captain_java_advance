package Day8;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static int id = 1;

    private static ThreadLocal<Map<Integer, UserData>> threadLocalMap = new ThreadLocal<>(){
        @Override
        protected Map<Integer, UserData> initialValue(){
            Map<Integer, UserData> info = new HashMap<>();
//            UserData userData = new UserData("defaultUser", "defaultPassword");
//            info.put(userData, 0);
            return info;
        }
    };


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        }
    }

    public static void instantiate(Scanner sc) throws InputMismatchException, InterruptedException {
//        Map<Integer, UserData> info = threadLocalMap.get();
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();

        int min = 1;
        int max = 10;
        int random = (int)Math.floor(Math.random()*(max-min+1)+min);
        int total = random*1000;
        Thread.sleep(total);
        int currentId = id;

//        info.put(currentId, new UserData(username, password, total));
//        threadLocalMap.set(info);
    }

    public static void printDetails(Map<Integer, UserData> infoMap){
        infoMap.get(1).getDetails();
    }

}
