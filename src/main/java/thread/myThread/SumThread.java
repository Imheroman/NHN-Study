package thread.myThread;

public class SumThread implements Runnable {
    private int maxCount;
    SharedNumber sharedNumber;

    public SumThread(SharedNumber sharedNumber, int maxCount) {
        this.sharedNumber = sharedNumber;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (maxCount > count) {
            int number = sharedNumber.getNumber();
            sharedNumber.setNumber(number + 1);

            count++;
        }
    }
}
