package thread.threadMart;

import java.util.concurrent.ThreadLocalRandom;

/*
소비자는 매장에 입장 후 물건을 구매할 수 있다.
매장에는 입장 인원 제한이 있으므로, 인원 초과시 기다린다.
매장에 입장하면 물건을 구매하고, 퇴장한다.
1~10초 간격으로 구매한다.
 */

public class Consumer implements Runnable {
    private String name;
    private Store store;
    private int count = 0;
    private final int END_NUMBERS = 3;
    public final static int INTERVAL_TIMES = 1000;
    private int interval;

    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    private void itemBuying() {
        store.sell();
    }

    public void stop() {
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        while (count < END_NUMBERS) { // 물품 구매 횟수
            interval = ThreadLocalRandom.current().nextInt(INTERVAL_TIMES, INTERVAL_TIMES * 10);
            itemBuying();
            count++;

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        store.exit(this);
    }

    public String getName() {
        return name;
    }
}
