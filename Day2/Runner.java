package Day2;

public class Runner implements Runnable{

    private static final int MIN = 1;
    private static final int MAX = 4;
    private static final int GOAL =30;

    @Override
    public void run(){
        int i = 0;

        while (i<=GOAL){
            System.out.println(Thread.currentThread().getName() + ": "+i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ie){
                System.out.println(ie);
            }
            int random = (int)Math.floor(Math.random()*(MAX-MIN+1)+MIN);
            i += random;
            if(i>=GOAL){
                System.out.println(Thread.currentThread().getName() + " finished the race!");
                break;
            }
        }

    }

    public static void main(String[] args) {
        Runner runner = new Runner();

        Thread runner1 = new Thread(runner,"Runner1");
        Thread runner2 = new Thread(runner,"Runner2");
        Thread runner3 = new Thread(runner,"Runner3");

        runner1.start();
        runner2.start();
        runner3.start();
    }
}
