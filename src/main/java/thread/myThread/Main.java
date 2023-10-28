package thread.myThread;

public class Main {
    public static final int THREAD_NUMBERS = 2;
    public static final int TEST_ODD_NUMBERS = 8192;

    public static void main(String[] args) throws InterruptedException {
        SharedNumber sharedNumber = new SharedNumber();
        int beforeAddingNumber = sharedNumber.getNumber();
        Thread t1 = new Thread(new SumThread(sharedNumber, TEST_ODD_NUMBERS / THREAD_NUMBERS));
//        Thread t2 = new Thread(new SumThread(sharedNumber, TEST_ODD_NUMBERS/THREAD_NUMBERS));
        Thread t2 = new Thread(new SubThread(sharedNumber, TEST_ODD_NUMBERS / THREAD_NUMBERS));

        System.out.println(THREAD_NUMBERS + "의 쓰레드가 1씩 " + TEST_ODD_NUMBERS / THREAD_NUMBERS + "번 더하는 테스트입니다.");
        System.out.println("초깃값: " + beforeAddingNumber);

        t1.start();
        t2.start();
        t2.join();

        int afterAddingNumber = sharedNumber.getNumber();

        boolean isSameNumber = afterAddingNumber == TEST_ODD_NUMBERS;
        System.out.println(afterAddingNumber + "(쓰레드를 이용한 덧셈 결과값) == " + TEST_ODD_NUMBERS + "(기댓값) ? " + isSameNumber);
    }

}
