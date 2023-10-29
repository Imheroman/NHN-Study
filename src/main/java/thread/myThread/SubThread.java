package thread.myThread;

public class SubThread implements Runnable {
    private int maxCount;
    SharedNumber sharedNumber;

    public SubThread(SharedNumber sharedNumber, int maxCount) {
        this.sharedNumber = sharedNumber;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        int count = 0;

        while (maxCount > count) {
            int number = sharedNumber.getNumber();
            sharedNumber.setNumber(number - 1);

            count++;
        }
    }
}
