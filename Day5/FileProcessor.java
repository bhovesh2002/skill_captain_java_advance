package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessor {

    private int wordCount;
    private int lineCount;

    public FileProcessor(int wordCount, int lineCount){
        this.lineCount = lineCount;
        this.wordCount = wordCount;
    }

    public static Map<String, FileProcessor> processFile(Set<String> files, String dir) throws IOException{
        Iterator<String> filesIterator = files.iterator();
        Map<String, FileProcessor> filesReport = new HashMap<>();
        while (filesIterator.hasNext()){
            String fileName = filesIterator.next();
            String filePath = dir+"\\"+fileName;
            FileProcessor fileProcessor = calculate(filePath);
            filesReport.put(fileName, fileProcessor);
        }
        return filesReport;
    }

    public static FileProcessor calculate(String filePath) throws IOException {
        String readFile = String.join("", Files.readAllLines(Paths.get(filePath))).replaceAll("[^\\s\\.a-zA-Z0-9]", "");
        String[] words = readFile.split("\s+");
        String[] lines = readFile.split("\\.");

        int wordCount = words.length;
        int linesCount = lines.length;
        FileProcessor fileProcessor = new FileProcessor(wordCount, linesCount);
        return fileProcessor;
    }

    public static Set<String> listFiles(String dir) throws IOException{
        try(Stream<Path> stream = Files.list(Paths.get(dir))){
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String dir = "F:\\New folder\\JAVA III\\Day5\\Dir";
        Set<String> files = listFiles(dir);
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            try{
                Map<String, FileProcessor> filesReport = processFile(files, dir);
                return filesReport;
            }catch (IOException e){
                System.out.println(e);
                return null;
            }
        });
        Map<String, FileProcessor> filesReport = (Map<String, FileProcessor>) completableFuture.get();
        printReport(filesReport);
    }

    public static void printReport(Map<String, FileProcessor> filesReport){
        for(Map.Entry<String, FileProcessor> entry : filesReport.entrySet()){
            System.out.println("FileName: "+entry.getKey());
            System.out.println("Word Count: " + entry.getValue().wordCount);
            System.out.println("Line Count: " + entry.getValue().lineCount);
        }
    }

}
