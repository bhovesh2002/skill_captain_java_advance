package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordCountES implements Runnable{

    private String filePath;

    public WordCountES(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            String str = String.join("", Files.readAllLines(Paths.get(filePath))).replaceAll("[^\\sa-zA-Z0-9]", "");

            String[] words = str.split("\s+");
            System.out.println("Count for thread: "+ Thread.currentThread().getName()+ " is "+ words.length);

        }catch (IOException ioe){
            System.out.println(ioe);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        String dirPath = "F:\\New folder\\JAVA III\\Day3\\Dir";
        System.out.println("Thread name starts from 1 with 1 being the first file and 6th being the last");
        executorService.submit(new WordCountES(dirPath+"\\Hello.txt"));
        executorService.submit(new WordCountES(dirPath+"\\World.txt"));
        executorService.submit(new WordCountES(dirPath+"\\Again.txt"));
        executorService.submit(new WordCountES(dirPath+"\\How.txt"));
        executorService.submit(new WordCountES(dirPath+"\\Long.txt"));
        executorService.submit(new WordCountES(dirPath+"\\Do.txt"));

        executorService.shutdown();

    }

}
