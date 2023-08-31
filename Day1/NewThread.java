package Day1;

public class NewThread extends Thread {

    private int startNum;

    public NewThread(int startNum) {
        this.startNum = startNum;
    }

    public void run() {
        int currentNum = startNum;
        int lastNum = 10;
        if (startNum % 2 == 0) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
        while (currentNum <= lastNum) {
            System.out.println(currentNum);
            currentNum += 2;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }
}
