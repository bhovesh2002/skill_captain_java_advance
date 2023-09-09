package Day10;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getInstance();

        LogWriterThread writer1 = new LogWriterThread(logger, "writer1");
        LogWriterThread writer2 = new LogWriterThread(logger, "writer2");
        LogWriterThread writer3 = new LogWriterThread(logger, "writer3");

        writer1.start();
        writer2.start();
        writer3.start();

        writer1.join();
        writer2.join();
        writer3.join();

    }

}
